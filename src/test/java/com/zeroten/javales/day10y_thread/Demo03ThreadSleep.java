package com.zeroten.javales.day10y_thread;

// 休眠
public class Demo03ThreadSleep {

    public static void main(String[] args) {
        try {
            System.out.println("休眠前");
            Thread.sleep(2000);
            System.out.println("休眠后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
