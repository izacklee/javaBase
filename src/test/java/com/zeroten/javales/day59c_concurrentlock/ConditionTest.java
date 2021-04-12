package com.zeroten.javales.day59c_concurrentlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ConditionTest {

   ReentrantLock lock = new ReentrantLock();

   Condition condition = lock.newCondition();

   // 生产者
   public void producer() {

       try {

           lock.lock();

           System.out.println("生产者获取锁...");

           condition.signal();

           System.out.println("生产者唤醒消费者...");

       } finally {

           lock.unlock();

           System.out.println("生产者释放锁...");

       }

   }

    // 消费者
    public void consumer() {

       try {

           lock.lock();
//           lock.lockInterruptibly();  // 锁中断 可不用再等

           System.out.println("消费者获取锁...");

           try {
               condition.await();  // 等带的同时会释放锁 然后生产者才能获取到锁
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

//           // sleep 不会释放锁 生产者就获取不到  只有等这个sleep执行完了 才能获取到 导致最终执行逻辑变了
//           try {
//               Thread.sleep(30*1000);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }

           System.out.println("消费者开始消费...");

       } finally {

           lock.unlock();

           System.out.println("消费者释放锁...");
       }

    }

    public static void main(String[] args) {

        ConditionTest conditionTest = new ConditionTest();

        new Thread(() -> {conditionTest.consumer();}, "consumer").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {conditionTest.producer();}, "producer").start();

    }

}
