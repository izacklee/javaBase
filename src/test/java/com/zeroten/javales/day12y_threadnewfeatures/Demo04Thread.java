package com.zeroten.javales.day12y_threadnewfeatures;

import java.util.concurrent.*;

public class Demo04Thread {

    public static void main(String[] args) {

        // 6.自定义线程池
        // 线程等待队列（核心）
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(2);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, // 核心线程池大小 （处于执行状态的上限）
                4, // 最大线程池大小（处于队列中的个数上限）
                0,  // 线程最大空闲时间 0是不空闲
                TimeUnit.MILLISECONDS, // 时间单位
                bqueue  // 线程等待队列（用于缓存任务的阻塞队列）
                );
        Thread t1 = new Thread(new MyThread4());
        Thread t2 = new Thread(new MyThread42());

        pool.execute(t1); // 执行
        pool.execute(t2); // 执行
        pool.execute(t1); // 任务状态
        pool.execute(t1); // 任务状态
        pool.execute(t1); // 任务状态
        pool.execute(t1); // 任务状态

        pool.shutdown();
    }
}

class MyThread4 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread42 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("非常耗时的：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
