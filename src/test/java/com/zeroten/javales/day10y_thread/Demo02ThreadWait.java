package com.zeroten.javales.day10y_thread;

// 等待
public class Demo02ThreadWait {

    public static void main(String[] args) {
        Demo02ThreadWait t = new Demo02ThreadWait();
        t.test();
    }

    // 要有synchronized修饰，也就是必须要持锁，否则报：IllegalMonitorStateException 错误
    public synchronized void test() {
        try {
//            this.wait(); // 一直等待下去
            this.wait(3000); // 等待3秒，3秒内如果未被唤醒，则自动离开等待状态
            System.out.println("等待结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
