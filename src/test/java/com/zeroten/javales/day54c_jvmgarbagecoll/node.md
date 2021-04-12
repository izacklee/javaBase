#### 1.G1收集器
  （1）特点
  （2）应用场景
       2.1）面向服务端应用，针对具有大内存、多处理器的机器。
       2.2）在下面情况时，使用G1可能比CMS（一般用得多）好：
            2.2.1）超过50%的Java堆被活动数据占用；
            2.2.2）对象分配频率或年代提升频率变化很大；
            2.2.3）GC停顿时间过长（长于0.5至1秒）。
            是否一定采用G1呢？也未必：如果现在采用的收集器没出现问题，不用急着去选择G1；
  （3）JVM常用启动参数
        3.1）-Xmx1024m, -Xmx1g单位（g,m,k 对应内存大小单位） 指整个堆内存大小；
        3.2）-Xms512m 指初始堆内存大小；
        3.3）-Xmn256m （相当于将新生代的初始、最小、最大值设置为同一个：-XX:NewSize=-XX:MaxNewSize） 指新生代初始值的大小；
        3.4）-Xss512k 一个线程对应一个栈，这个指栈内存的大小;
        3.5）-XX:PretenureSizeThreshold，大于这个值的参数直接在老年代分配，缺省为0表示不会直接分配在老年代；
            （注：如果在新生代分配失败且对象是一个不含任何对象引用的大数组，也可被直接分配到老年代。）
        3.6）-XX:-DisableExplicitGC，禁用显示GC，System.gc()
        3.7）-XX:+PrintGCDetails，打印GC详情
        3.8）-XX:+PrintGCTimeStamps：JVM启动到GC开始经历的时间
        3.9）-XX:+PrintGCDateStamps:GC发生的具体时间点
        3.10）-XX:+PrintCommandLineFlags:让JVM打印出那些已经被用户或者JVM设置过的详细的XX参数的名称和值。
        3.11）-XX:NewRatio=2,老年代和新生代的内存比例为2:1
        3.12）-XX:SurvivorRatio=8，表示eden和1个survivor区的比例，survivor大小=Xmn/(SurvivorRatio+2)-Dxxx=yyy，
              启动时配置系统属性，在java中通过System.getProperty(“xxx”)获取相应的值           
        具体参见：内存溢出示例代码：OOM.java，栈溢出示例代码：StackOverflow.java
  （4）linux常用操作及问题定位
       4.1）linux常用操作见微信公众号文章：https://mp.weixin.qq.com/s/b7fd-5Zabo_ptEmmxcrgmQ
       4.2）cpu100%问题定位见微信公众号文章：https://mp.weixin.qq.com/s/hgSlPOtj8jGnjtK2R2IbTg

#### 2.Java并发编程
  （1）线程（Thread）是操作系统进行调度的最小单位，Java中的线程是对操作系统线程的封装。
  （2）线程的创建有两种方式：
      2.1）自己写一个类继承于java.lang.Thread类，并重写run()接口。
      2.2）实现java.lang.Runnable接口，并传给Thread的构造函数。