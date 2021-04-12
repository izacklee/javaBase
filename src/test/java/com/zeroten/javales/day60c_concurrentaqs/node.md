#### 1.AQS源码解读
   1.1 AQS总结
    1.1.1 同步框架
    1.1.2 CLH（Craig, Landin, and Hagersten）自旋锁，同步队列
    1.1.3 条件队列（wait,notify）
    1.1.4 独占方式-ReentrantLock，共享方式（CountDownLatch）
    1.1.5 LockSupport.part,LockSupport.unpark
    
   答疑：
        1.Volatile和Synchronized的区别？
            1.Volatile单个变量可见性
              （变量的可见性，指的是它被修改后其他线程可以立即看到最新结果的能力，不从寄存器而是从内存中读取 /* 降低速度来保证可见性 */）
                寄存器是和CPU一起的，只能存少量的信息，但是存取速度特别快。
                存储器是指的是硬盘,U盘,软盘,光盘之类的存储工具，包含寄存器和内存,速度最慢;
                内存指的是内存条,由于一般的硬盘读取速度很慢,所以用先将硬盘里面的东西读取到内存条里面,
                    然后在给CPU进行处理,这样是为了加快系统的运行速度。
            2.Synchronized原子性
            3.操作性能
        2.ReentrantLock原理
            示例：
                1）中断方式获取锁
                2）超时方式获取锁
                3）公平/非公平方式获取
        3.CountDownLatch原理
            示例：
                1）并行调用