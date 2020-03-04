package com.zeroten.javales.day09y_thread;

// 线程
public class Demo01Thread {

    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(Integer.MAX_VALUE);
        Thread t = new MyThread();
//        t.setDaemon(true); // 守护进程
        t.start();
        System.out.println("----是否开启了守护线程----" + t.isDaemon()); // ----是否开启了守护线程----true

        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

    }
}

// 创建线程的两种方式
// 1.创建子类继承Thread类，并覆盖重写run方法  --- 单继承
class MyThread extends Thread {

    @Override
    public void run() {  // 线程的结束是run方法执行完毕
        // 打印线程的名称
        Thread t = Thread.currentThread();  // 获取当前线程
//        t.setName("main-1"); // 设置线程名

        System.out.println(t.getName()); // Thread-0  获取线程名
    }
}


// 2.实现Runnable接口，并覆盖重写run方法   --- 多实现
class MyRunnable implements Runnable {

    @Override
    public void run() {

    }
}