#### 1.大数据
   （1）大数据是什么？大数据就是，数据量很大的情况
   （2）能干什么？
       1）存：大数据的起步数据量1TB，1PB数据相当于1024TB，一台计算机显然是没办法来保存如此庞大的数据量的
       2）查：数据量很大，就需要解决一个查询的问题
       3）但是，这个不是取代关系型数据库的技术
       4）hadoop是大数据技术的核心和基石，但是他不是代表大数据的全部
       5）hadoop产生的历史背景：
         5.1）apache有个项目叫Lucence，这是一个搜索引擎
         5.2）Netch：是一个分布式的爬虫框架
         5.3）hadoop：顶级项目
            在这样的一个背景下，为了解决存和查的问题，进而hadoop产生了
            5.3.1）HDFS：存，分布式存储系统 
                    HDFS块大小默认64MB(或者是128MB)
            5.3.2）MapReduce：算，离线计算
            5.3.3）YARN：负责优化
   （3）搭建hadoop环境
        1）关闭防火墙：系统偏好设置->安全性与隐私->防火墙->关闭
        2）安装gcc： brew install gcc // c语言运行库   
        3）安装lrzsz：brew install lrasz  
        4）上传hadoop安装包到/usr/local/download文件夹下
        5）解压，修改文件夹名为hadoop并移动到/usr/local文件夹下 
             解压：tar xzf hadoop-2.7.1.tar.gz
             修改文件夹名为hadoop：mv hadoop-2.7.1 hadoop
             移动到/usr/local文件夹下：sudo mv -f hadoop /usr/local
        6）配hadoop环境变量，文件路径：/etc/profile，配置完刷新source /etc/profile
            配置信息：
            # hadoop环境变量
            export HADOOP_HOME=/usr/local/hadoop
            export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin        
      ? 7）生成私钥：ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
            t：t是type的缩写
               -t 即指定密钥的类型，密钥的类型有两种，一种是RSA，一种是DSA
            rsa：是指RSA算法
               RSA：RSA加密算法是一种非对称加密算法，是由三个麻省理工的牛人弄出来的，RSA是他们三个人姓的开头首字母组合。
               DSA：Digital Signature Algorithm (DSA)是Schnorr和ElGamal签名算法的变种。
                    为了让两个linux机器之间使用ssh不需要用户名和密码。所以采用了数字签名RSA或者DSA来完成这个操作。
                    ssh-keygen默认使用rsa密钥，所以不加-t rsa也行，如果你想生成dsa密钥，就需要加参数-t dsa。 
            p：原密码，''意思是不填写
            f：生成密钥的路径
      ? 8）将私钥追加到公钥：cat ~/.ssh/id_dsa.pub >> ~/.ssh/authorized_keys  
        9）在hadoop下创建三个文件夹
            mkdir tmp   // 临时目录
            mkdir -p ./hdfs/name // namenode目录   记录位置
            mkdir -p ./hdfs/data  // datanode目录   存文件   
        10）复制mapred-site.xml文件：cp mapred-site.xml.template  mapred-site.xml
        11）配置hadoop
            /usr/local/hadoop/etc/hadoop/slaves    // 注：mac版搭建伪集群不用改
            /usr/local/hadoop/etc/hadoop/hadoop-env.sh 
            /usr/local/hadoop/etc/hadoop/yarn-env.sh 
            /usr/local/hadoop/etc/hadoop/core-site.xml 
            /usr/local/hadoop/etc/hadoop/hdfs-site.xml 
            /usr/local/hadoop/etc/hadoop/mapred-site.xml 
            /usr/local/hadoop/etc/hadoop/yarn-site.xml
        12) 格式化hdfs：/usr/local/hadoop/bin/hdfs namenode -format   
        13）启动start-dfs.sh：/usr/local/hadoop/sbin/start.dfs.sh
            解决报Unable to load native-hadoop library问题，
            找到配置文件：/usr/local/hadoop/etc/hadoop/log4j.properties，配置如下代码：
                log4j.logger.org.apache.hadoop.util.NativeCodeLoader=ERROR   
        14）输入jps查看java进程
            jps查看进程DataNode未启动，原因是执行了多次hdfs namenode -format命令，导致NameNode的clusterID改变而DataNode却没变。
            解决步骤：
                a 停止所有进程：sbin/stop-all.sh 
                b 将namenode的clusterID复制到datanode的clusterID
                    namenode的clusterID路径文件：/usr/local/hadoop/hdfs/name/current/VERSION
                    datanode的clusterID路径文件：/usr/local/hadoop/hdfs/data/current/VERSION
                    (SecondaryNameNode是协调资源的)
                c 启动所有进程 /sbin/start-all.sh 
        15）访问：http://www.hadoopceshi.com:50070，可以看到hadoop的一个管理界面  // hdfs端口:500070
        16）启动start-yarn.sh：/usr/local/hadoop/sbin/start-yarn.sh
        17）输入jps查看java进程
        18）访问：http://www.hadoopceshi.com:8099，可以看到监控yarn的管理界面
            15、18能正常打开看到页面，说明hadoop的环境搭建成功了。
        参考网址：https://www.jianshu.com/p/07dcb5f99665 // Mac单机安装Hadoop    
   （4）HDFS的shell操作，基本和linux一样
        4.1）操作文件
            创建文件夹：hadoop fs -mkdir /input
            创建文件：hadoop fs -touchz /input/word
                写入内容：echo hello a | hadoop fs -appendToFile - /input/word
            查看文件夹：hadoop fs -ls /
            上传文件：hadoop fs -put temp/wordcount /input
                报：WARN hdfs.DFSClient: DataStreamer Exception异常
                解决办法：
                    a 检查防火墙是否已关闭，关闭了继续b、c、d
                    b 停止所有进程：sbin/stop-all.sh 
                    c 删除/usr/local/hadoop/hdfs/name和/usr/local/hadoop/hdfs/data文件夹 // 元数据(镜像)的文件夹
                        (原因：执行hdfs namenode -format次数太多，可能导致元数据文件出问题)
                    d 启动所有进程 /sbin/start-all.sh
            下载文件：hadoop fs -get /input/wordcount temp 
            查看文件：hadoop fs -cat /input/wordcount  
        4.2）操作目录
        4.3）没有切换目录
        4.4）删除文件用-rm(删除指定文件) -rmr(递归删除)   
                hadoop fs -rmr /input/wordcount
        4.5）hadoop hdfs shell命令网址：http://hadoop.apache.org/docs/r1.0.4/cn/hdfs_shell.html 
   （5）端口类型
        5.1）HDFS监控端口：50070
        5.2）YARN监控端口：8099
        5.3）HDFS访问端口：9000   
                         
   百度云盘最核心的技术就是HDFS
   区块链是去中心化，也就是没有namenode
   企业总线雪崩效应可以用服务协调优化
   在企业当中大数据开发是比web的门槛低很多，因为流程基本是固定的。      
   爬虫：获取网络资源的一种技术。通过请求，把请求到的html爬下来，全部保存到一个库里（服务器本地），
        生成索引、快照（如百度的快照，一块一块的，图片、文件）、内容（网址）
       
    
