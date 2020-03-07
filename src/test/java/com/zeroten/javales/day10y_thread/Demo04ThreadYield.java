package com.zeroten.javales.day10y_thread;

// 让步
public class Demo04ThreadYield {

    public static void main(String[] args) {
        for (int i=0; i<20; i++) {
            Thread t1 = new Thread(new MyThread3(i%2==1 ? true : false));
            t1.setPriority(i%2 ==1 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY);
            t1.start();

        }

    }
}

class MyThread3 implements Runnable{

    private final boolean flag; // 用于判断是否需要让步

    public MyThread3(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        if (flag) {
            System.out.println(t.getName() + "让步前");
            Thread.yield();
            System.out.println(t.getName() + "让步后");
        } else {
            System.out.println(t.getName() + "未让步");
        }
    }
}
