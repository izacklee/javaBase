package com.zeroten.javales.day09y_thread;

public class Demo02Thread {

    public static void main(String[] args) {
//        new Thread(new MyRunnable2()).start();
//        new Thread(new MyRunnable2(), "num 1").start();

        // 并发
        // 尽可能保持在某一个瞬时状态，但是并不能确保所有的线程，按照这个顺序执行
        for (int i=0; i<20; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    Thread t = Thread.currentThread();
                    System.out.println(t.getName());
                }
            },"t" + i).start();
        }
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        // 单个线程，是什么顺序，就是什么顺序
        Thread t = Thread.currentThread();
        for (int i=0; i<10; i++) {
            System.out.println(t.getName() + ":" +i);
        }
    }
}
