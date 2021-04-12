2020.10.23
#### 1 synchronied和java.util.concurrent.locks.lock的异同？
   偏向锁 -> 轻量锁 -> 重量级锁 （都属于synchronized的范畴）
   偏向锁：当只有1个线程进入临界区（加synchronized代码附近），
        无锁状态下，会加个偏向锁（对象头指向线程ID）。1~2线程时性能高。
   轻量锁：无需等待，中间无间隔，用完刚好再来个。
   重量锁：同一时刻只能有1个线程能操作，其他线程则需要等待。
   synchronied锁的操作比较耗时，需要其他线程等待时间长，所以不适用于锁很大的逻辑，很大的代码块。
#### 2 什么场景下可以使用重入锁？
   1）递归调用。
   2）此线程调用同一对象其它synchronized或者有同步锁函数。
#### 3 什么场景下可以使用volatile替换成sychronized？
   在单个变量时，可以用volatile替换成sychronized，但要注意volatile虽然可以保证单个变量读/写的
   原子性，但不能保证变量复合操作的原子性，例如i++。
#### 4 函数式编程
   函数式编程体现是一种编程思想，是面向数学的抽象，通过表达式将原数据映射为新数据。
   函数式接口：接口中只有一个方法。
#### 5 总结
   1）返回值 func(操作数)
    a 有操作数，有返回值
       Function，Predicate()
    b 无返回值（消费者）
        Consumer
        例子：
            Consumer<Integer> consumer = i -> System.out.print(" " + i);
    c 无操作数（提供者）
        Supplier
        例子：
            Supplier<String> supplier = () -> "hello world";
            System.out.println(supplier.get()); // hello world
    
   