package com.zeroten.javales.day10y_thread;

// 静态同步
public class Demo08ThreadStaticSynchronized {

    public static void main(String[] args) {
        new Thread(new MyThread8()).start();
        new Thread(new MyThread8()).start();
        new Thread(new MyThread8()).start();
        new Thread(new MyThread8()).start();

    }
}
class MyThread8 implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(D.test2());
        }
    }
}
class D {
    private static int i;
    public static synchronized int test() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ++i;
    }

    public static int test2() {
        synchronized(D.class) {  // 静态锁的是类
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ++i;
        }
    }

    // 非静态和静态混用  ---> 不推荐这么用
//    public synchronized int test3() {
//        synchronized(D.class) {  // 静态锁的是类
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return ++i;
//        }
//    }
}
