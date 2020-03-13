package com.zeroten.javales.day11y_thread.homework;

import java.util.LinkedList;

public class MyQueue1<T> {
    // 会大量的弹压，或者进出数据
    private LinkedList queue = new LinkedList();
    private int maxSize = 0; // 队列的度
    private static final int DEF_MAX_SIZE = 20; // 默认最大队列长度

    public MyQueue1() {
        this(DEF_MAX_SIZE);
    }

    public MyQueue1(int maxSize) {
        this.maxSize = maxSize;
    }

    /*
    * 由生产者添加队列元素
    * @param t
    */
    public synchronized void put(T t) {
       /*
        if (this.queue.size() >= maxSize) {
            try {

                // 问题：当队列满的时候，应当加的东西没加，会缺一个值。

                System.out.println("当前队列已满，等待：" + this.queue.size());
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("队列添加元素：" + t);
            this.queue.addFirst(t);

            // size等于1的情况下 去唤醒消费者线程
            if (this.queue.size() == 1) {
                this.notifyAll();
            }
        }
        */

        if (this.queue.size() >= maxSize) {
            try {

                System.out.println("当前队列已满，等待：" + this.queue.size());
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("队列添加元素：" + t);
        this.queue.addFirst(t);

        // size等于1的情况下 去唤醒消费者线程
        if (this.queue.size() == 1) {
            this.notify();
        }

    }

    /*
    * 由消费者消费队列元素
    * 如果size为0，则等待
    * @return
    */

    public synchronized T get() {
        /*
        if (this.queue.size() == 0) {
            try {
                System.out.println("当前队列为空，开始等待：" + this.queue.size());

                // 问题：当队列为空时等待，只不过这个等待被唤醒后，
                // 当前线程应当立即取一个值，然后返回，而现在else里才会取值，
                // 所以这里只会立刻返回一个null。

                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            T t = (T) this.queue.removeLast();
            // 消费完之后，size等于maxSize - 1，则去唤醒生产者线程
            if (this.queue.size() == maxSize - 1) {
                this.notifyAll();
            }
            // 删除并返回最后一个节点
            return t;
        }

        return null;

         */

        if (this.queue.size() == 0) {
            try {
                System.out.println("当前队列为空，开始等待：" + this.queue.size());

                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = (T) this.queue.removeLast();
        // 消费完之后，size等于maxSize - 1，则去唤醒生产者线程
        if (this.queue.size() == maxSize - 1) {
            this.notify();
        }
        // 删除并返回最后一个节点
        return t;

    }
}
