package com.zeroten.javales.day09y_thread;

public class Demo04Thread {

    public static void main(String[] args) {
        A a = new A(); // 使用但是同一个对象！！！~
        for (int i=0; i<10000; i++) {
            new Thread(new MyRunnable4(a)).start();
        }

    }
}

class A {
    private int i = 1;
    public synchronized void add() {
        // 新值和旧值的问题
        ++i; // i = i + 1; {1.读，2.改，3.赋值} 对前一步不可见（旧值不可见）
        System.out.println(i);
    }
}

class MyRunnable4 implements Runnable {
    private final A a;
    public MyRunnable4(final A a) {
        this.a = a;
    }

    @Override
    public void run() {
        this.a.add();
    }
}
