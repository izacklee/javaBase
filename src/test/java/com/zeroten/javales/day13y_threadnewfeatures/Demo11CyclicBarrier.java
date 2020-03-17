package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo11CyclicBarrier {

    public static void main(String[] args) {
        // 当所有子线程执行完毕，才能执行主线程
        CyclicBarrier cb = new CyclicBarrier(5, new MainTask()); // 5是子线程数量
        new Thread(new SubTask(cb)).start();
        new Thread(new SubTask(cb)).start();
        new Thread(new SubTask(cb)).start();
        new Thread(new SubTask(cb)).start();
        new Thread(new SubTask(cb)).start();

    }
}

class MainTask implements Runnable {
    @Override
    public void run() {
        System.out.println("主线程");
    }
}

class SubTask implements Runnable {
    private final CyclicBarrier cb;
    public SubTask(final CyclicBarrier cb) {
        this.cb = cb;
    }
    @Override
    public void run() {
        System.out.println("子线程");
        try {
            Thread.sleep(1000);
            // 调用await的数量，必须等于子线程设置数量，否者会一直处于等待状态，不放开。
            cb.await(); // 调用await通知障碍器，通知子线程执行完毕。
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("通知之后");
    }
}
