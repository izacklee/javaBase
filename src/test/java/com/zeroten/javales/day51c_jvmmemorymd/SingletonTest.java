package src.test.java.com.zeroten.javales.day51c_jvmmemorymd;

/**
 * 标准的单例设计
 */
public class SingletonTest {

    private SingletonTest() {}

    private volatile static SingletonTest singleton; // 静态的，一个类只能有一个

    public static SingletonTest getSingleton() {

        if (singleton == null) {  // 1 并发的时候可能会出问题，不是真正的单例
            // 读不存在竞争，不需要加锁
            synchronized(SingletonTest.class) { // 2 并发的时候可能会出问题，不是真正的单例
                if (singleton == null) {
                    /**
                     *  下列代码singleton = new SingletonTest()的时候，实际会发生三个步骤
                     *  1 分配空间
                     *  2 初始化构造函数
                     *  3 堆上空间赋值给singleton
                     *  问题：有可能2还没初始化完或者还没初始化 就执行3赋值给singleton了
                     *      导致1就不为null 结果返回了一个不完整的实例
                     *  解决办法：
                     *      对singleton变量使用volatile修饰符修饰，从而避免了重排序问题，解决问题
                     */
                    singleton = new SingletonTest(); // 3
                }
            }

        }
        return singleton;  // 线程并发很快就返回了 但初始化慢 所以可能返回的是不完整的空间
    }
}
