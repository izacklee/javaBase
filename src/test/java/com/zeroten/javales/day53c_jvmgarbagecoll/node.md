#### 1.Minor and Full GC
   （1）Minor GC
        又称新生代GC，指发生在新生代的垃圾收集动作；
        因为Java对象大多是朝生夕灭，所以Minor GC非常频繁，一般回收速度也比较快；
   （2）Full GC
        又称Major GC或老年代GC，指发生在老年代的GC；
        出现Full GC经常会伴随至少一次的Minor GC（不是绝对，Parallel Sacvengel收集器就可以选择设置Major GC策略）;
        Major GC速度一般比Minor GC慢10倍以上（因Major GC是整堆收集，收集内容比较多，需要进行那一堆判断，所以比较慢）；
   （3）GC详细分类
        3.1）GC其实准确分类只有两大类（Partial GC、Full GC）；
          Partial GC：并不收集整个GC堆的模式；
          Full GC：收集整个堆；
   （4）GC触发时机
        HotSpot VM是目前使用范围最广的Java虚拟机。
        4.1）Young GC：当young gen中的eden（新生代的内存区域 新创建的对象都会被分配到Eden区）区域满时触发。
             Full GC：当准备要触发一次young GC时，如果发现统计数据说之前young GC的平均晋升大小比目前old gen剩余的空间大，
                则不会触发young GC而转为触发full GC（因为HotSpot VM的GC里，除了CMS的concurrent collection之外，
                其它能收集old gen的GC都会同时收集整个GC堆，包括young gen，所以不需要事先触发一次单独的young GC）；或者，
                如果有perm gen（永久代）的话，要在perm gen分配空间但已经没有足够空间时，也要触发一次full GC；
                或者System.gc()、heap dump带GC，默认也是触发full GC。
        4.2）HotSpot VM里其它非并发GC的触发条件复杂一些，不过大致的原理与上面说的其实一样。
        4.3）并发GC的触发条件就不太一样。以CMS GC为例，它主要是定时去检查old gen的使用量，当使用量超过了触发比例就会启动一次
             CMS GC，对old gen做并发收集。
   （5）safepoint（安全点）
        5.1）安全点是在程序执行期间的所有GC Root已知并且所有堆对象的内容一致的点。
        5.2）SafePoint位置
            5.2.1）uncounted-loop
            5.2.2）方法结束位置
        5.3）counted-loop vs uncounted-loop
            5.3.1）counted-loop
                for (int i=0; i<100; i++) {a++;}
            5.3.2）uncounted-loop
                for (long i=0; i<100; i++) {a++;}  // 换成long类型后，jvm认为这个数值很大
            5.3.3）uncounted-loop
                while (a!=0) {b++;}
   
   VM options配置： -XX:+PrintGCDetails -XX:+PrintSafepointStatistics -XX:PrintSafepointStatisticsCount=1 
                    -XX:+SafepointTimeout -XX:SafepointTimeoutDelay=2000
   （6）触发安全点VM操作
        6.1）GC
        6.2）Biased lock revocation 取消偏向锁
        6.3）Class redefinition（e.g.javaagent，AOP的代码植入） 
        6.4）Various debug operation（e.g.threaddump一条或所有线程，heapdump） 
   （7）查看安全点（安全点可能造成JVM的停顿）
        7.1）打印JVM停顿时间
            -XX:+PrintGCApplicationStoppedTime
        7.2）查看进入安全点原因
            -XX:+PrintSafepointStatistics
            -XX:PrintSafepointStatisticsCount=1   
   （8）安全点日志
        8.1）第一段是时间戳，VM Operation的类型，以及线程概况
            total: 所有的java线程数
            initially_running: 号召进入安全点时，还是Running状态的线程数
            wait_to_block: 所有线程都不Running时，仍不是Block状态的线程数
        8.2）第二段是到达安全点的各个阶段以及执行操作所花的时间，其中最重要的是vmop
            spin: VMOP线程使用自旋，等待所有线程都不是Running的时间
            block: VMOP线程基于锁，等待所有线程都是Block的时间
            sync: spin+block +其他，这是从开始到进入安全点的总耗时
            cleanup: 退出清理所用时间
            vmop: 真正执行VM Operation的时间  
   （9）安全点优化
        9.1）强制在CountLoop后加入SafePoint 
            -XX:+UseCountedSafepoints（JDK8上是有Bug的，可能会导致JVM Crash，到JDK9才修复的，具体参考JDK-8161147）
        9.2）修改循环index为long型
        9.3）禁用自旋锁
            -XX:-UseBiasedLocking
        9.4）打印进入SafePoint慢的线程
            -XX:+SafepointTimeout
            -XX:SafepointTimeoutDelay=2000
    老年代不适合复制算法，因为复制算法需要双倍的空间，生命周期比较长，难以回收掉，会需要特别大的空间，所以不适合。
   （10）CMS收集器的问题
        10.1）对CPU资源非常敏感
            并发收集虽然不会暂停用户线程，但因为占用一部分CPU资源，还是会导致应用程序变慢，总吞吐量降低。
        10.2）无法处理浮动垃圾，可能出现"Concurrent Mode failure"失败
            10.2.1）浮动垃圾：并发清除时，用户线程新产生的垃圾，称为浮动垃圾。
                    这使得并发清除时需要预留一定的内存空间，不能像其他收集器在老年代几乎填满再进行收集；
                    也要可以认为CMS所需要的空间比其他垃圾收集器大；
                    "-XX:CMSInitiatingOccupancyFraction"：设置CMS预留内存空间；
                    JDK1.5默认值为68%；
                    JDK1.6变为大约92%； 
            10.2.2）"Concurrent Mode Failure"失败
                    如果CMS预留内存空间无法满足程序需要，就会出现一次"Concurrent Mode Failure"失败；
                    这时JVM启用后备预案：临时启用Serail Old收集器，而导致另一次Full GC的产生；
                    这样的代价是很大的，所以CMSInitiatingOccupancyFraction不能设置得太大。
         10.3）产生大量内存碎片
               由于CMS基于"标记-清除"算法，清除后不进行压缩操作；
               产生大量不连续的内存碎片会导致分配大内存对象时，无法找到足够的连续内存，从而需要提前触发另一次Full GC动作。
           
        
        
        