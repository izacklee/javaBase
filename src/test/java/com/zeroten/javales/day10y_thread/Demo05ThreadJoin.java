package com.zeroten.javales.day10y_thread;

// 线程的合并
public class Demo05ThreadJoin {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new MyThread5());
        Thread t2 = new Thread(new MyThread5());
        Thread t3 = new Thread(new MyThread5());
        t1.start();
        System.out.println("主线程1");
        t1.join(); // 设置线程合并
        System.out.println("主线程2");
        t2.start();
        System.out.println("主线程3");
        t2.join();
        System.out.println("主线程4");
        t3.start();
    }
}

class MyThread5 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i=0; i<20; i++) {
            System.out.println(t.getName() + "第" + i);
        }
    }
}
