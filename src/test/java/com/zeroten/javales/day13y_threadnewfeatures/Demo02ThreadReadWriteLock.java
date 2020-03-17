package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo02ThreadReadWriteLock {

    public static void main(String[] args) {
        B b = new B();
        new Thread(new MyThread2(b)).start();
        new Thread(new MyThread2(b)).start();
        new Thread(new MyThread2(b)).start();
    }
}

class MyThread2 implements Runnable {
    private final B b;
    public MyThread2(final B b) {
        this.b = b;
    }

    @Override
    public void run() {
        b.r();
    }
}

class MyThread21 implements Runnable {
    private final B b;
    public MyThread21(final B b) {
        this.b = b;
    }
    @Override
    public void run() {
        b.w();
    }
}

class B {
    private ReadWriteLock lock = new ReentrantReadWriteLock(false);

    public void r() {
        // 读锁没有排它性
        lock.readLock().lock();
        System.out.println("获取读锁");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.readLock().unlock();
        System.out.println("释放读锁");
    }

    public void w() {
        // 写锁有排它性（只要有写锁的时候，读写锁是不能获取的）
        lock.writeLock().lock();
        System.out.println("获取写锁");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.writeLock().unlock();
        System.out.println("释放写锁");
    }
}