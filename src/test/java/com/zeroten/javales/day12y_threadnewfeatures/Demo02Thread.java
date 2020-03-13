package com.zeroten.javales.day12y_threadnewfeatures;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo02Thread {

    public static void main(String[] args) {

        // 1.固定大小的线程池
//        ExecutorService pool = Executors.newFixedThreadPool(2); // 指定核心线程的个数
        // 2.单任务线程池
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        // 3.可变尺寸线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        // 执行线程
        // 子类继承Thread的方式
//        pool.execute(new Thread2());

        // 实现Runnable的方式
        Thread t = new Thread(new MyThread2()); // 唯一对象
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);

        pool.shutdown(); // 关闭线程

//        for (int i=0; i<5; i++) {
//            pool.execute(new MyThread2());
//            pool.execute(new MyThread2());
//            pool.execute(new MyThread2());
//        }


    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("3->" + Thread.currentThread().getName()); // 3->pool-1-thread-2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("5->" + Thread.currentThread().getName()); // 5->pool-1-thread-1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
