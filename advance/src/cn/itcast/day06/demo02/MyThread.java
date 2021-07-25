package cn.itcast.day06.demo02;

public class MyThread extends Thread {


    public MyThread() {
    }

    public MyThread(String name) {
        // 调用父类带参数的构造方法，把线程的名称传给父类，让父类（Thread）给子线程取一个名字。
        super(name);
    }

    @Override
    public void run() {
        // 获取线程的名称 链式编程
//        Thread.currentThread().setName("线程1");
        System.out.println(Thread.currentThread().getName());
    }
}
