2020.4.7
#### 1.Hadoop架构与原理
   1）Hadoop1.0版本两个核心：HDFS+MapReduce
   2）Hadoop2.0版本，引入了Yarn。核心：HDFS+YARN+MapReduce
       Yarn是资源调度框架。能够细粒度的管理和调度任务。此外，还能够支持其他的计算框架，比如spark等。
#### 2.集群相关概念
   1）心跳检测：检测集群当中各个节点是否存活。
   2）单点故障：由于主服务器节点发生故障，从而导致所有集群的成员节点，都无法工作。
   3）选举策略：从所有成员节点当中，选举出一个新的节点作为主服务器。
   4）数据安全：数据备份，数据同步。
#### 3.Hadoop的组件
   1）Namenode：负责保存数据的位置，IP，顺序等等，本身不保存元数据。
   2）Datanode：负责保存元数据。
   3）数据块：
        1.0：64M
        2.0：128M
   4）机架：包含了有若干个Datanode的一个资源划分，通常情况下由hadoop自行划分。
#### 4.Hadoop的api操作
   1）安装两个依赖： // 注意依赖的版本要对应上hadoop的版本
    a.hadoop-commom 
    b.hadoop-hdfs
   2）编译和配置hadoop，到hosts文件配置hadoop主服务器地址
   3）强制加载hadoop
   4）指定用户，指定hadoop的根目录
   5）创建与hdfs的连接
   6）获取文件系统，hdfs的操作，和我们再java中操作file大同小异
   7）api操作
#### 5.MR编程
   1）什么是MR：简单一致模型，正常的在mysql当中能完成的查询，都可以使用MR来完成，主要是针对大数据量的查询（1TB），
      但是他的查询效率很低（但是这个低是相对的，同样的数据量mysql完成不了这样的查询）
      小数据量用mysql，大数据量用MR（硬盘读写）。
   2）环境搭建
      2.1）安装两个依赖：
        a.hadoop-mapreduce-client-core
        b.hadoop-mapreduce-client-common
   3）WordCount：相当于mr的helloword
      3.1）创建mapper类：
        3.1.1）四个泛型：
            a.前两个是输入类型 key/value
            b.后两个是输出类型 key/value
              Mapper<KEYIN, VALUEIN, KEYPUT, VALUEOUT>
                KEYIN：偏移量（从哪开始读，也就是下标，下标从0开始，换行后依旧递增而不是再从0开始），一般就是LongWritable型
                VALUEIN：读取的数据类型，一般就是Text型（具体看实际）
      3.2）Map阶段输出后，mr会根据key进行排序，合并
      3.3）创建Reduce类：
         3.3.1）是个泛型：
            a.前两个和mapper阶段输出类型一致
            b.后两个是最终结果怎么展示
#### 6.作业
   1）获取各个部门的平均工资。         