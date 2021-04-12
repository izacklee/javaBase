#### 1.用户登录
   （1）验证用户名密码
   （2）如果要验证用户是否登录，常规做法是把用户的登录信息，放入本地服务器；但如果说登录请求是发往一个
        分布式的负载均衡部署情况下的服务器集群（多个服务器），那么这个时候，不能正常存入session，因为
        一个服务器对应一个session（可通过中间件解决，如：MongoDB(基于分布式文件存储的数据库)、Zookeeper）。
   （3）共享sessionID：共享变量
        3.1）在集群当中，某些不可以在独立服务器当中去使用或者保存的数据，这种数据往往需要脱离某个服务器
            集群的节点，作为共享的中间件。
        3.2）在集群当中最重要的业务是数据的缓存或持久化。 
        3.3）要共享的数据包括：缓存（临时数据），文件（大文件/小文件） 
   （4） sessionId无法共享的问题与解决办法    
        4.1）假设，我把用户数据保存到mysql当中的一个临时表，那么这种情况下，是否可以解决sessionId无法共享的问题？
             答：4.1.1）可以解决，但是这种方式极大的增加数据库访问的压力。
                 4.1.2）繁琐（需要访问service->访问dao->连接数据库->建表->维护等）
        4.2）假设，我们把用户的登录数据，保存到HDFS这样的文件系统当中，能否解决sessionId无法共享的问题？
             答：4.2.1）可以解决，但HDFS是保存大文件，PB（百亿亿字节）级别的数据才适用，而他的时效性无法得到保证（有时很慢）
        4.3）解决方案：我们希望有一种能够保存数据，且访问时效高，且不那么繁琐的一种中间件
             答：使用缓存中间件，比如：Zookeeper、MongoDB、redis
                           zk(大项目)      vs             redis(小项目)
               吞吐量         略低                          略高(每秒10万请求很轻松)
               可扩展性        高                           略低
               数据安全性       高                           略低    
        
#### 2.搭建Zookeeper（伪分布式）
   （1）把zookeeper-3.4.9.tar.gz压缩包上传到/usr/local/download目录下
   （2）解压tar -zxf zookeeper-3.4.9.tar.gz zookeeper
   （3）移动到hadoop目录下：sudo mv -f zookeeper /usr/local/hadoop/
   （4）配置zookeeper的环境变量vim /etc/profile
        # zookeeper环境变量
        export ZOOKEEPER_HOME=/usr/local/hadoop/zookeeper
        export PATH=$PATH:$ZOOKEEPER_HOME/bin
   （5）刷新环境变量source /etc/profile
   （6）到/usr/local/hadoop/zookeeper/conf下复制三个zoo_sample.cfg配置文件
        cp zoo_sample.cfg zoo01.cfg
        cp zoo_sample.cfg zoo02.cfg
        cp zoo_sample.cfg zoo03.cfg 
   （7）到/usr/local/hadoop/zookeeper目录下创建个临时文件夹：mkdir temp                
   （8）到temp目录下，创建三个文件夹，名字自定义
        mkdir dir1
        mkdir dir2
        mkdir dir3
   （9）在8创建好的三个文件夹下分别创建三个名为myid(文件名不能错)的文件，并分别加入标记内容
        /usr/local/hadoop/zookeeper/temp/dir1
            app$ touch myid  
            app$ echo 1 > myid
       /usr/local/hadoop/zookeeper/temp/dir2
                   app$ touch myid  
                   app$ echo 2 > myid        
        /usr/local/hadoop/zookeeper/temp/dir3
                    app$ touch myid  
                    app$ echo 3 > myid
   （10）以上步骤zookeeper配置完成，下面是启动
        使用zookeeper的配置文件启动
        到/usr/local/hadoop/zookeeper/bin目录下分别执行
            ./zkServer.sh start zoo01.cfg
            ./zkServer.sh start zoo02.cfg
            ./zkServer.sh start zoo03.cfg   
   （11）启动完之后，执行jps查看启动进程信息
         出现如下信息，说明zookeeper启动成功，可用了：
            19667 QuorumPeerMain
            19655 QuorumPeerMain
            19643 QuorumPeerMain  
            
#### 3.缓存Zookeeper的使用
    
   （1）以节点存储数据：zk所有节点都可以访问
   （2）zk主要的种类
         2.1）持久化节点：当客户端断开连接以后，数据依旧保存
         2.2）临时节点：当客户端断开后，该节点删除
            (-s是顺序节点 -e是临时节点 不加(默认)是持久节点)
   （3）在zk当中，所有的操作都共享同一个事务ID(Zxid)     
        cZxid：节点创建时间 create
        mZxid：节点最近一次修改时间 modify
        pZxid：该节点的子节点列表最后一次被修改时的时间，子节点内容变更不会变更pZxid  
   （4）zk有事务管理
   （5）shell操作
           zk客户端登录：./zkCli.sh -server 127.0.0.1:2181
           创建节点
           create /filecloud  // 错误！！！ 必须要给一个根节点才能创建
           create /filecloud filecloud // 正确！！！ 
   （6）API操作  
        zookeeper的环境，最好和zookeeper的依赖版本对应上
   （7）监听的作用：当节点发生变化，可以立刻去更新配置文件
   （8）zookeeper关闭
        zkServer.sh stop zoo01.cfg
        zkServer.sh stop zoo02.cfg
        zkServer.sh stop zoo03.cfg
   
   Token的设计：
        1.http都是明文的，如果你的token丢失，要尽可能的保护token
        2.密钥的设计：
            2.1 生成一个临时标识，把这个临时标识和用户ID组合
            2.2 把组合后的标识，再加密
            2.3 临时标识可以顺序（可以自己指定规则）增加或者变化
        3.密钥超时：无操作30分钟过期
            3.1 流程：请求抵达，检查token是否存在，不存在返回登录页，存在则先检查时间戳和当前时间跨度
                是否超过30*60*1000，不超过，则更新该时间戳，超过则删除该节点，并返回登录页。                      
            1：23          
    JMX port端口被占用解决办法：
        1 执行：lsof -i:1099 查看端口使用情况
            lsof(list open files) 查看进程打开的列表
        2 把1查询结果的pid杀掉：kill -9 pid 解决
    Java建模语言（JML Java Model Language）是一种行为接口规范语言    
        