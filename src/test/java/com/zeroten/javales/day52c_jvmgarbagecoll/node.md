#### 1.Java内存区域
   （1）运行时内存区域
        1.1）方法区（线程共享） 也叫永久代 JDK8开始被废弃 取而代之的是元空间(Metaspace)
            1.1.1）常量
            1.1.2）类信息
            1.1.3）静态常量
            1.1.4）运行时常量池String
            1.1.5）JIT代码（Just-In-Time Compiler 即时编译器）
        1.2）堆（线程共享）  分新生代和老年代（垃圾回收算法：新生代和老年代的算法不一样）
            分新生代和老年代的目的是为了使 JVM 能够更好的管理堆内存中的对象，包括内存的分配以及回收。
            对象在Survivor区中每熬过一次Minor GC，年龄就会增加1岁，当它的年龄增加到一定程度时，就会被移动到年老代中。
            堆的内存模型大致为： image 默认的，新生代 ( Young ) 与老年代 ( Old ) 的比例的值为 1:2 
                ( 该值可以通过参数 –XX:NewRatio 来指定 )
            1.2.1）对象实例
                1.2.1.1）对象头
                    a 运行时数据
                    b Hashcode，GC分代年龄，锁状态标识，偏向锁线程ID...
                1.2.1.2）实例数据（类中定义的数据）
                1.2.1.3）内存对齐填充
        1.3）虚拟机栈（线程私有，面相Java方法）
            1.3.1）栈帧1...N
                1.3.1.1）局部变量表
                    a 8种基本类型
                    b Reference
                1.3.1.2）操作数栈
                1.3.1.3）方法出口
   （2）直接内存（不属于JVM运行时内存区域）  
   
#### 2.对象的存活判断
   （1）正在用的对象不能回收，不用的才能回收。
   （2）JVM也有生命周期，只是很长，所以不用理会。

#### 3.Java引用类型
   强引用（Strong Reference）、软引用（Soft Reference）、弱引用（Weak Reference）、虚引用（Phantom Reference）4 种，
       这 4 种引用的强度依次减弱。
   （1）强引用：只要强引用存在，垃圾回收器将永远不会回收被引用的对象。哪怕内存不足时，JVM也会直接抛出OutOfMemoryError，不会去回收。
        如果想中断强引用与对象之间的联系，可以显示的将强引用赋值为null，这样一来，JVM就可以适时的回收对象了。
   （2）软引用：在内存不足时，系统才会回收软引用对象。
   （3）弱引用：只要JVM开始进行垃圾回收，那些被弱引用关联的对象都会被回收。
   （4）虚引用：如果一个对象仅有虚引用，就相当于没有任何引用一样，随时可能被回收。
   
   // 一般初始化堆内存（-Xms20）和最大值堆内存（-Xmx20m）设置成一样 为的是当JVM扩展时影响性能损耗
   // -DstrongRef=true 设置运行时的参数让运行时可以拿到 strongRef为参数名 true意思是可以获取到 false获取不到
   //   例子：boolean isStrongRef = Boolean.parseBoolean(System.getProperty("strongRef"));
   // -XX:+PrintGCDetails 开启了GC日志输出
   // -Xmn10m 是新生代（-XX:NewSize=100M）  -XX:OldSize=10M 老年代（10m） 新生代+老年代=20m 最大就是20m
   // 提示空间小时 全部增加10倍 空间够大就不会触发GC了
   VM options的配置：-Xmx20m -Xmn10m -Xms20 -DstrongRef=true -XX:+PrintGCDetails 
   
#### 4.GC的算法
   （1）标记-清除（Mark-Sweep）
        1.1）标记：从根集合开始扫描，对存活的对象进行标记。
        1.2）清除：扫描整个内存空间，回收未被标记的对象，使用free-list记录可以区域（不需要额外空间）
   （2）标记-压缩（Mark-Compact） 
        1.1）标记：与标记-清除一样
        1.2）压缩：再次扫描，并往一端滑动存活对象（连续空闲内存区域）  
   （3）复制算法（Copying）
        1.1）复制算法的核心就是，将原有的内存空间一分为二，每次只用其中的一块，在垃圾回收时，将正在使用的对象复制到另外一个内存空间中，
                然后将该内存空间清空，交换两个内存的角色，完成垃圾回收。
                如果内存中的垃圾对象较多，需要复制的对象就较少，这种情况下适合使用该方式并且效率比较高，反之，则不适合。
        1.2）优点：在垃圾对象多的情况下，效率较高。清理后，内存无碎片。
        1.3）缺点：在垃圾对象少的情况下，不适用，如：老年代内存。分配的2块内存空间，在同一个时刻，只能使用一般，内存使用率较低。 
    
#### 5.垃圾收集器
   （1）7种分代收集器
        Serial、ParNew、Parallel Scavenge、Serial Old、Parallel Old、CMS、G1
        1.1）新生代收集器：Serial、ParNew、Parallel Scavenge；
        1.2) 老年代收集器：Serial Old、Parallel Old、CMS;
        1.3）整堆收集器：G1;
        可以搭配使用的收集器（有连线）：
            Serial/Serial Old、Serial/CMS、ParNew/CMS、Parallel Scavenge/Serial Old
            、Parallel Scavenge/Parallel Old、G1；
        Serial Old是作为CMS出现"Concurrent Model Failure （并发模式失败）"失败的后备预案
    （2）并行和并发收集器
        并行：指多条垃圾收集器并行工作，但此时用户线程仍然处于等待状态；
            如：ParNew、Parallel Scavenge、Parallel Old；
        并发：指用户线程与垃圾收集器同时执行（但不一定是并行的，可能是交替执行）；
             用户程序在继续运行，而垃圾收集程序线程运行于另一个CPU上；
             如：CMS、G1（也有并行）