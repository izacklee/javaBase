package com.zeroten.javales.day11y_thread;

/*
* 生产线程
*/
public class ProducerThread implements Runnable {

    private final MyQueue q;
    private final String message;
    public ProducerThread(final MyQueue q, final String message) {
        this.q = q;
        this.message = message;
    }

    @Override
    public void run() {
        // 每隔0.5秒生产一个
        while(true) {
            try {
                Thread.sleep(500);
                q.put(Thread.currentThread() + "：" + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
