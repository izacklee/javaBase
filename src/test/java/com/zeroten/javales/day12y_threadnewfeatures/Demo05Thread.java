package com.zeroten.javales.day12y_threadnewfeatures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// 7.有返回值的线程
public class Demo05Thread {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<String> f = pool.submit(new Callable<String>() {

            @Override
            public String call() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "这是线程执行完毕返回的字符串";
            }
        });
        System.out.println(f.get()); // 这是线程执行完毕返回的字符串

        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("其他线程1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("其他线程2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
