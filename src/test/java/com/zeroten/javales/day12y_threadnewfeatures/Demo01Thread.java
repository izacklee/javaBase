package com.zeroten.javales.day12y_threadnewfeatures;

import java.util.LinkedList;

// 简单的线程池的思想
public class Demo01Thread {

    public static void main(String[] args) {
        // 创建一个线程的集合
        LinkedList<Thread> ts = new LinkedList<>();

        // 根据需求，把指定个数的线程对象存入到线程集合
        ts.add(new Thread(new MyThread()));
        ts.add(new Thread(new MyThread()));
        ts.add(new Thread(new MyThread()));
        ts.add(new Thread(new MyThread()));
        ts.add(new Thread(new MyThread()));

        for (Thread t : ts) {
            // 需要的时候再调用start开启线程
            t.start();
        }
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
