package cn.itcast.day06.demo01;

/*
    获取线程的名称：
        1.使用Thread类中的getName()方法
            String getName()：返回该线程的名称
        2.可以先获取到当前正在执行的线程，使用线程中的getName()获取线程名称
            static Thread currentThread()：返回对当前正在执行的线程对象的引用。
*/
public class Demo01GetThreadName {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        // 调用start方法，开启线程，执行run方法
        mt.start();
        new MyThread().start();

        // 获取当前进程对象的引用
//        System.out.println(Thread.currentThread()); // Thread[main,5,main]
        // 获取线程的名称  链式编程
        System.out.println(Thread.currentThread().getName()); // main
    }

}
