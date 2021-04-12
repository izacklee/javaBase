package com.zeroten.javales.day61c_concurrentblocking;

import java.util.concurrent.TimeUnit;
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

    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(()->{

            try {

                lock.lock();

                System.out.println("thread1 get lock success");

                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                lock.unlock();
            }

        });

        thread1.start();

        Thread.sleep(100);
//
        // 以中断的方式获取锁
        Thread thread2 = new Thread(()->{

            try {
//                  lock.lock();  // 没有中断 卡在了Thread.sleep(10000)
                lock.lockInterruptibly();  // 中断后会抛异常

                System.out.println("thread2 get lock success");

//                if (lock.tryLock(2, TimeUnit.SECONDS)) {
//                    System.out.println("获取到锁");
//                } else {
//                    System.out.println("获取锁失败");
//                }
            }
            catch (InterruptedException e) {
//                e.printStackTrace();

                System.out.println("thread2 get lock interrupted");

            }
            finally {

                lock.unlock();
            }

        });

        thread2.start();

        thread2.interrupt();

    }

}
