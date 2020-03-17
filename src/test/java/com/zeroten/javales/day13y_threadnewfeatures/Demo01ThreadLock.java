package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo01ThreadLock {

    public static void main(String[] args) {
        A a = new A();
       new Thread(new MyThread(a)).start();
       new Thread(new MyThread(a)).start();
       new Thread(new MyThread(a)).start();
       new Thread(new MyThread(a)).start();
    }
}

class MyThread implements Runnable {
    private final A a;
    public MyThread(final A a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.test1();
    }
}

class A {
    private Lock lock = new ReentrantLock();
    public void test1() {
        lock.lock(); // 获得锁
        // 要保护的数据，写在这里
        // ...

        System.out.println(Thread.currentThread().getName() + "获得锁");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock(); // 释放锁
        System.out.println(Thread.currentThread().getName() + "释放锁");
    }

    public void test2() {

    }
}