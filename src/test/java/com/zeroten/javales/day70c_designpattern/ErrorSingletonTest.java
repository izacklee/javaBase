package com.zeroten.javales.day70c_designpattern;

/**
 * 单例错误案例
 */
public class ErrorSingletonTest {

    // 构造函数私有 限制外部直接new创建对象（单例必须加的）
    private ErrorSingletonTest() {}

    // 成员变量没加volatile 错误！！！ new对象不具有原子性，会导致重排序
    private static ErrorSingletonTest singletonTest;

    // 错误1
//    public static ErrorSingletonTest getSingleton() {
//
//        // 并发时可能出现new多次，比如当一个线程new到一半时，另一个线程也走到这，后面就会继续往下走再new一次
//        if (null == singletonTest) {
//
//            singletonTest = new ErrorSingletonTest();
//        }
//
//        return singletonTest;
//    }

    // 错误2
    // 原因：每一次调用该方法都要等待（经获取锁释放锁的过程）。实际上只是第一次调用时初始化就行了，后面只是读不用再写了。
//    public synchronized static ErrorSingletonTest getSingleton() {
//
//        if (null == singletonTest) {
//
//            singletonTest = new ErrorSingletonTest();
//        }
//
//        return singletonTest;
//    }

    // 错误3
    public synchronized static ErrorSingletonTest getSingleton() {

        if (null == singletonTest) {

            // 并发时可能出现new多次，比如有两个线程都走到这，一个线程先获取锁，然后new完之后释放锁，另一个线程获取到锁之后，
            // 会继续往下走再new一次
            synchronized(ErrorSingletonTest.class) {

                singletonTest = new ErrorSingletonTest();
            }

        }

        return singletonTest;
    }

    public static void main(String[] args) {

    }
}


