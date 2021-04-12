2020.4.12
#### 1.Hive
   没有专门学大数据的，一般就是学Java后，顺便学一点
   1）为什么要有Hive：是把复杂的编程，简化为HQL（类似于SQL的查询语言，Hive HQL不是Hibernate的）的使用，可以最大限度的
      减少程序员的学习成本。
   2）Hive：是数据仓库平台（数据库）
   3）Hive（HQL）和RDBMS（SQL）比较
    查询语言            HQL                                     SQL
    数据库的存储位置    HDFS                                Raw Device或Local FS（本地文件系统）
    数据格式           用户定义                                 系统决定
    数据更新           不支持（也就是不能UPDATE和DELETE）          支持
    索引               无                                       有
    执行              MapReduce                               Executor
    执行延迟            高                                       低
    可扩展性            高（数据和数据量这块 数据量无上限）          低（数据量大概几千万条）
    数据规模            大                                       小
    Hive和传统关系型数据库的功能差异：Hive是以数据存储优先，而关系型数据库是以查询效率优先。
#### 2.安装Hive
   1）首先需要有MYSQL之类的关系型数据库
   2）要有Hadoop集群
   3）要配置的步骤比较多，所以请务必仔细检查配置后，再执行
    下面这两配置完后，启动hadoop执行：start-all.sh
    3.1）修改hive-site.xml中所有包含 ${system:java.io.tmpdir} 字段的 value ，即路径
    3.2）修改hive-site.xml中所有 ${system:user.name} 改为${user.name} 
   4）Hiveservice2这个服务：是提供JDBC访问的
   5）Hive的数据类型
    5.1）Int
    5.2）Double
    5.3）String
    5.4）Date
   6）建库和建表
    6.1）实际上是在HDFS当中，创建了对应的目录
    6.2）数据需要上传，上传数据文件到对应库和表的目录下
    6.3）Hive的查询，本质还是执行MR
    6.4）要执行MR的情况
        6.4.1）全表扫描
        6.4.2）排序
        6.4.3）分组
        6.4.4）只需要MAP阶段就能完成的查询，不需要MR
    6.5）Hive当中关联查询
        6.5.1）Hive是没有主外键的
        6.5.2）内联：inner join（要写全）
        6.5.3）外联：left join / right join (要写全)
        6.5.4）任何情况下，只要执行了表关联，就一定会执行MR操作
        6.5.5）分区/分桶 
    6.6）Hive是不可以修改数据，但是可以插入数据，不是在原来文件的基础上添加，而是以新的文件进行保存
    6.7）使用Hive：一般把Hive作为增量表进行数据归档的，写到Hive里的数据，通常需要加一个时间戳，用于标明数据的批次
    6.8）用Hive一定要用到队列
        
   问题1：org.apache.hadoop.yarn.exceptions.InvalidAuxServiceException: The auxService:mapreduce_shuffle 
        does not exist
        解决办法：
           a 在yarn-site.xml文件添加如下内容
            <property> 
                <name>yarn.nodemanager.aux-services</name>
                <value>spark_shuffle,mapreduce_shuffle</value>
                <description>启动shuffle</description>
            </property>
            <property>
                <name>yarn.nodemanager.aux-services.spark_shuffle.class</name>
                <value>org.apache.spark.network.yarn.YarnShuffleService</value>
                <description>NodeManager中辅助服务对应的类</description>
            </property>
           b 安装spark（参考网址：https://blog.csdn.net/penyok/article/details/81483527）
           c 添加依赖的jar包，在jar包目录（/usr/local/spark/yarn）下执行：
               cp spark-2.2.0-yarn-shuffle.jar /usr/local/hadoop/share/hadoop/yarn/lib
           d 启动spark，再重启hadoop
   问题2：Logging initialized using configuration in jar:file:/usr/local/hive/lib/hive-common-2.1.1.jar!
          /hive-log4j2.properties Async: true
            Exception in thread "main" java.lang.RuntimeException: org.apache.hadoop.ipc.RemoteException(
            org.apache.hadoop.hdfs.server.namenode.SafeModeException): Cannot create directory /tmp/hive
            /app/bdd8eab1-0f8b-4380-843a-518281e0b29b. Name node is in safe mode.
         问题原因：以前曾经安装了Hive或MySQL，重新安装Hive和MySQL以后，导致版本、配置不一致。
         解决办法：执行schematool -dbType mysql -initSchema 初始化当前 Hive 版本的 Metastore 架构。
#### 3 Hive的HQL装载数据
   从本地加载数据:
   load data local inpath '/home/hadoop/student_1' into table student;  
   从HDFS上加载数据:
   load data inpath '/home/hadoop/student_1' into table student; 
#### 4 Hive的HQL下载数据
   从本地下载数据:
   insert overwrite local directory '/home/hadoop/hive_tmp' select * from student2;
   从HDFS上下载数据:
   insert overwrite directory '/hive_tmp' select * from student2; 
