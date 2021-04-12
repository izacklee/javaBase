#### 1.阻塞队列
   入队和出队的阻塞
        队列都是有容量的
        入队满了put不进去(false)或者出队完了get为空(false)就会造成阻塞
        常见的阻塞队列使用场景：ThreadPoolExecutor（线程池）
   1.1 Synchronized VS ReentrantLock
    相同点：
        (1) 可重入的（同一个线程持有锁之后，再次获取锁时无需竞争，可以获得成功）   
    不同点：
       （1）一个是Java的关键字，一个是JUC下面的类，Synchronized{}，ReentrantLock显示调用。
            显示调用: 直接使用类名调用。 
            隐式调用: 基于事件的隐式调用风格的思想是构件不直接调用一个过程，而是触发或广播一个或多个事件。
            public synchronized void a(){}这种写法等效于public void a() {synchronized(this){}}
       （2）synchronized不响应中断，ReentrantLock可响应中断（lockInterruptibly方法 以中断方式获取锁 抛异常）
       （3）synchronized不支持获取锁时设置超时时间，ReentrantLock可以(用tryLock方法设置)
       （4）synchronized不支持尝试获取锁，ReentrantLock可以（通过中断获取 设置超时获取）
       （5）性能方面，ReentrantLock更占优（可通过高并发不停的获取释放锁测试）
            synchronized重量级锁，复杂。
       （6）ReentrantLock提供条件等待
    使用频率不高时用synchronized，不容易出错。
    使用频率高时用lock，比如下单。