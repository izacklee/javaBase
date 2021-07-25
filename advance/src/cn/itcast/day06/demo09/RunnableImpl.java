package cn.itcast.day06.demo09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    卖票的案例
*/
public class RunnableImpl implements Runnable{
    // 定义一个多线程共享的票源
    private int ticket = 100;

    // 创建Lock指向ReentrantLock的对象 多态
    Lock l = new ReentrantLock();

    // 设置线程卖票
    @Override
    public void run() {
        // 使用死循环，让卖票操作重复执行
        while (true) {
            l.lock(); // 获取锁
            try {
                Thread.sleep(10);
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
                    ticket--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 无论是否有异常，都会执行，提高程序效率
                l.unlock(); // 释放锁
            }
        }
    }
}
