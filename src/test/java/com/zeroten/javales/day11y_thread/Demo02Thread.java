package com.zeroten.javales.day11y_thread;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Demo02Thread {

    public static void main(String[] args) {
        System.out.println("8 + 7 * 2 - 9 / 3");
        A a = new A();
        a.add("王丽坤");
        new Thread(new MyThread1(a)).start();
        new Thread(new MyThread2(a)).start();
    }
}

class MyThread1 implements Runnable {
    private final A a;

    public MyThread1(final A a) {
        this.a = a;
    }
    @Override
    public void run() {
        // 业务时长不一致，删除集合中的元素
        try {
            Thread.sleep(2000);
            a.work();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        // 业务时长不一致，删除集合中的元素
        try {
            Thread.sleep(2000);
            a.work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class A {
    // 线程安全的List
    private List<String> l = Collections.synchronizedList(
            new LinkedList<String>());

    public synchronized void work() {
        int size = this.size(); // 不确定这个变量是否也是安全的 因是变化的
        System.out.println(Thread.currentThread().getName() + "：" + size);
        if (size > 0) {
            System.out.println(Thread.currentThread().getName() + "：" + size);
            this.remove(0);
        }
    }

    public synchronized void add(String str) {
        l.add(str);
    }

    public synchronized String get(int index) {
        return l.get(index);
    }

    public synchronized int size() {
        return l.size();
    }

    public synchronized void remove(int index) {
        l.remove(index);
    }

}