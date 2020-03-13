package com.zeroten.javales.day12y_threadnewfeatures;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo03Thread {

    public static void main(String[] args) {
        // 4.延迟线程池
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        // 5.单任务延迟线程池
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        Thread t = new Thread(new MyThread3());
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.schedule(t, 5000, TimeUnit.MILLISECONDS); // 设置延时时间
        pool.execute(t);

        pool.shutdown();
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
