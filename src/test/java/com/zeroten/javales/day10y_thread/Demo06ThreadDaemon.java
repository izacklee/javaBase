package com.zeroten.javales.day10y_thread;

// 守护线程
public class Demo06ThreadDaemon {

    public static void main(String[] args) throws Exception {
        // 公主死了，骑士也得死。
        Thread t1 = new Thread(new MyThread6()); // 公主
        Thread t4 = new Thread(new MyThread62()); // 公主
        Thread t2 = new Thread(new MyThread62()); // 骑士
        Thread t3 = new Thread(new MyThread62()); // 骑士

        t1.start(); // 用户线程
        System.out.println("t1--------------");
        t1.join();
        System.out.println("t4--------------");
        t4.start(); // 用户线程

        t2.setDaemon(true); // 设置t2为守护线程
        t2.start();
        t3.setDaemon(true);  // 设置t3为守护线程
        t3.start();
    }
}

class MyThread6 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i=0; i<20; i++) {
            try {
                Thread.sleep(500);
                System.out.println(t.getName() + "第" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread62 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i=0; i<20; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(t.getName() + "第" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
