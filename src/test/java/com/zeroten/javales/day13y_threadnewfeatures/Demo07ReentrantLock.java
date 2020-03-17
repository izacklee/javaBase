package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo07ReentrantLock {

    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock(); // 相当于同步
        // 调度：条件变量
        Condition c = lock.newCondition();
        Condition c2 = lock.newCondition();
        // 一定是同一个锁的对象操作才有效
        c.await(); // 等待
        c.signalAll(); // 唤醒
        lock.unlock();

    }
}
