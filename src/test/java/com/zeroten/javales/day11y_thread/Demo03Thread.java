package com.zeroten.javales.day11y_thread;

public class Demo03Thread {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        // 多生产者
        new Thread(new ProducerThread(q, "生产者1")).start();
//        new Thread(new ProducerThread(q, "生产者2")).start();
//        new Thread(new ProducerThread(q, "生产者3")).start();

        // 多消费者
        new Thread(new ConsumerThread(q)).start();
        new Thread(new ConsumerThread(q)).start();
        new Thread(new ConsumerThread(q)).start();
    }
}
