package com.zeroten.javales.day59c_concurrentlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的作用域
 */
public class LockScopeTest {

    private static volatile LockScopeTest singleton;

    private static ReentrantLock lock = new ReentrantLock();

    private LockScopeTest() {}

    // synchronized加在方法上这种写法功能上没有问题 但是性能上不好
    // 因为new LockScopeTest()只需要第一次new 后面就不需要了 synchronized还存在 多个地方调用并发时 性能就会降低
//    public static synchronized LockScopeTest getSingleton() {
//
//        if (singleton == null) {
//            singleton = new LockScopeTest();
//        }
//
//        return singleton;
//
//    }

    public static LockScopeTest getSingleton() {

        if (singleton == null) {

            synchronized (LockScopeTest.class) {

                if (singleton == null) {
                    singleton = new LockScopeTest();
                }
            }

        }

        return singleton;

    }

    public static LockScopeTest getSingleton2() {

        if (singleton == null) {
            try {
                lock.lock();
                {
                    if (singleton == null) {
                        singleton = new LockScopeTest();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        return singleton;
    }
}
