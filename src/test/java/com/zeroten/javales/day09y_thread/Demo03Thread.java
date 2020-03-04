package com.zeroten.javales.day09y_thread;

public class Demo03Thread {
    // 线程传参
    public static void main(String[] args) {

    }
}

class MyRunnable3 implements Runnable {
    // 给一个final
    private final int random;

    // 创建构造
    public MyRunnable3(final int random) {
        this.random = random;
    }

    @Override
    public void run() {

    }
}
