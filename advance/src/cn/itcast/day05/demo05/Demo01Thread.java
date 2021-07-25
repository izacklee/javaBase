package cn.itcast.day05.demo05;

/*
    创建多线程的第一种方式：创建Thread类的子类
    java.lang.Thread类：是描述线程的类，我们想要实现多线程程序，就必须继承Thread类

    实现步骤：
        1.创建一个Thread类的子类
        2.在Thread类的子类中重写Thread类的run方法，设置线程任务（开启线程要做什么？）
        3.创建Thread类的子类对象
        4.调用Thread类中的方法start，开启新线程，执行run方法
            void start()：使该线程开始执行，Java虚拟机调用该线程的run方法。
            结果是两个线程并发运行，当前线程（main线程）和另一个线程（创建的新线程，执行其run方法）。
            多次启动一个线程是非法的。特别是当前线程已经结束后，不能再重新启动。

    Java程序属于抢占式调度，哪个线程的优先级高，就先执行哪个线程，同一优先级，随机选一个执行。
*/
public class Demo01Thread {

    public static void main(String[] args) {
        // 创建Thread类的子对象
        MyThread mt = new MyThread();
        // 创建的新线程 执行
        mt.start();
//        mt.start(); // 错误！ 不能多次启动一个线程，java.lang.IllegalThreadStateException 非法线程异常

        // main线程
        for (int i = 0; i < 10; i++) {
            System.out.println("main：" + i);
        }
    }

}
