package com.zeroten.javales.day11y_thread;

/*
* 消费者线程
*/
public class ConsumerThread implements Runnable {
    private final MyQueue q;
    public ConsumerThread(final MyQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        // 每一秒钟消费一个
        while(true) {
            try {
                Thread.sleep(1000);
                Object o = q.get();
                System.out.println("消费者返回：" + o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
