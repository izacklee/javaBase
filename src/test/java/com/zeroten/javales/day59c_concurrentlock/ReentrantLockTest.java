package com.zeroten.javales.day59c_concurrentlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁（同一个线程 获取到锁之后 在内部不需要释放锁还能再次获取 不需要等）
 */
public class ReentrantLockTest {

    private Integer count = 0;

    public Integer getCount() {

        return count;
    }

    static ReentrantLock lock = new ReentrantLock();

    public void add() {

        try {

            lock.lock();

            add0();

        } finally {
            lock.unlock();
        }
    }

    private void add0() {

        try {

            lock.lock();  // 仍然可以获取到锁 核心把当前线程改为获取到锁的线程（获取成功把次数加下 就直接返回）

            count++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } finally {

            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

//        Thread thread1 = new Thread(()->{
//
//            try {
//
//                lock.lock();
//
//                System.out.println("thread1 get lock success");
//
//                Thread.sleep(10000);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//
//                lock.unlock();
//            }
//
//        });
//
//        thread1.start();
//
//        Thread.sleep(100);
//
//        // 以中断的方式获取锁
//        Thread thread2 = new Thread(()->{
//
//            try {
//
//                lock.lockInterruptibly();
//
//                System.out.println("thread2 get lock success");
//
//            } catch (InterruptedException e) {
////                e.printStackTrace();
//
//                System.out.println("thread2 get lock interrupted");
//
//            } finally {
//
//                lock.unlock();
//            }
//
//        });
//
//        thread2.start();

//        thread2.interrupt();

        ReentrantLockTest test = new ReentrantLockTest();

        // 启动10个线程 执行add方法
        for (int i=0; i<10; i++) {

            new Thread(()->{

                test.add();

            }).start();

        }

        // java.lang.Thread.activeCount() 方法返回活动线程的当前线程的线程组中的数量
        // > 1 说明还有子线程在运行 则将主线程休眠100毫秒
        while(Thread.activeCount() > 1) {

            Thread.sleep(100);

        }

        System.out.println(test.getCount());  // 10

    }

}
