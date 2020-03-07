package com.zeroten.javales.day10y_thread;

public class Demo01Thread {

    public static void main(String[] args) {
        A a = new A();
        Thread t1 = new Thread(new MyThread1(a));
        t1.start();
        Thread t2 = new Thread(new MyThread2(a));
        t2.start();

    }
}

class MyThread1 implements Runnable {

    private final A a;

    public MyThread1(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000); // 睡眠1秒 就是等待1秒钟
                // 当某个条件不满足时，等待条件满足
                a.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 implements Runnable {

    private final A a;

    public MyThread2(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500); // 睡眠0.5秒 就是等待0.5秒钟
                // 某个业务完成，唤醒等待
                a.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class A {
    public synchronized void test1() {
        try {
            System.out.println("等待前");
            this.wait();
            System.out.println("等待后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test2() {
        this.notifyAll(); // 期望大家用这个来唤醒
        System.out.println("已唤醒");
    }
}
