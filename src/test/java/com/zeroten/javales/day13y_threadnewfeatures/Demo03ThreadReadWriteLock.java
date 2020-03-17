package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo03ThreadReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        lock.writeLock().lock();
        // 降级可以（无排它性，独占锁），也就是重入，先获取写锁能再获取到读锁
        System.out.println("获取写锁");
        lock.readLock().lock();
        // 升级不成立(有排它性，非独占锁)，先获取读锁就再无法获取写锁,因可能其它线程也持有读锁，所以不能把读锁升级为写锁。
        // 获取写锁时，发现当前读锁被占用，则获取失败
        System.out.println("获取读锁");

        lock.writeLock().unlock();
        System.out.println("释放写锁");

        // 如果到了这一步，就相当于，当前线程不再拥有写锁
        // 只拥有读锁，从独占锁升级为非独占锁
        lock.readLock().unlock();
        System.out.println("释放读锁");



        // 先释放读锁，不再是降级，没意义
        // 只相当于，在写锁当中，把读锁释放了，写锁还是那个写锁
//        lock.writeLock().lock();
//        System.out.println("获取写锁");
//        lock.readLock().lock();
//        System.out.println("获取读锁");
//
//        lock.readLock().unlock();
//        System.out.println("释放读锁");
//        lock.writeLock().unlock();
//        System.out.println("释放写锁");
    }
}
