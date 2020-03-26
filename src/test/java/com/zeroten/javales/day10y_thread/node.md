### 线程调度
    1.什么是线程调度：线程是不可控的，那么如何干预线程的执行？
        （1）等待(wait)：让某一个线程进入等待状态，等到条件满足后，被其他线程唤醒。
            1）等待需要在同步环境(synchronized)中，不持锁则报错。
            2）等待后被唤醒，需要重新经过持锁状态，然后回到就绪状态，等待资源分配。
        （2）休眠(sleep)：是让当前线程进入休眠状态，调用Thread的静态方法sleep，让线程休眠，
               休眠只能自己唤醒。
            1）休眠至少消耗指定时间。
            2）休眠不可被唤醒。
        （3）让步(yield)：
            线程总是存在优先级的，优先级范围是1-10之间，默认是5。
            1) 优先级是一门玄学。
            2）先设优先级，再启动线程。
            3）让步是不可控的。
            4) 没经过阻塞，直接回到就绪状态。
        （4）合并线程(join)：
            1) 是让并行的线程，变为串行状态。
            2) 先执行，再合并。
            3) 什么情况下要合并线程：某个线程要等待前一个线程结果时，
                需要合并，以等待前面的结果。(支付、redis) 
         (5) 守护线程：
            1) 当用户线程全部执行完毕后，守护线程立即停止，无论他执行成什么情况。
            2) 先设置，再执行
### 线程同步
    2.线程同步（比如：单例模式用，秒杀...）
        (1) 同步
            1) 同步方法：保护整个方法当中所有数据的安全
            2）同步代码块：保护方法中，某个区域数据的安全，
                意义在于让那些不需要考虑到同步数据的先执行，以提高运行效率
            3）一般来说，属于线程本身数据区的数据和读的数据
        (2) 非静态同步，锁是对象锁，只有相同实例才存在同步。
        (3) 静态同步，锁的是类，只要是这个类，就会触发同步。
           （静态锁类，非静态锁对象）
        (4) 不建议大家混杂同时使用静态和非静态锁。