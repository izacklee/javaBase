package cn.itcast.day07.demo02;

import cn.itcast.day06.demo06.RunnableImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    线程池：JDK1.5之后提供的
    java.util.concurrent.Executors： 线程池的工厂类，用来生成线程池
    Executors类中的静态方法：
        static ExecutorService	newFixedThreadPool(int nThreads) ：创建一个可重用固定线程数的线程池，
            以共享的无界队列方式来运行这些线程。
        参数：
            int nThreads：创建线程池中包含线程的数量
        返回值：
            ExecutorService接口，返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口接收（面向接口编程）
    java.util.concurrent.ExecutorService：线程池接口
        用来从线程池中获取线程，调用start方法，执行线程任务
            submit(Runnable task) ：提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
        关闭/销毁线程池的方法
            void shutdown()
    线程池的使用步骤：
        1.创建线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        2.创建一个类，实现Runnable接口，重写run方法，设置线程任务
        3.调用ExecutorService中的submit方法，传递线程任务（实现类），开启线程，执行run方法
        4.调用ExecutorService中的方法shutdown销毁线程池（不建议执行）
*/
public class Demo01ThreadPool {

    public static void main(String[] args) {
        // 创建数量为2的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);

        // 匿名内部类实现Runnable接口，重写run方法，设置线程任务
        /*Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };*/

        // 简化写法
        Runnable r = () -> System.out.println(Thread.currentThread().getName());

        // 开启线程
        es.submit(r); // pool-1-thread-1
        es.submit(r); // pool-1-thread-2
        // 线程执行完之后会自动归还线程池，可以重复使用
        es.submit(r); // pool-1-thread-1

//        es.shutdown(); // 销毁线程 不建议使用

//        es.submit(r); // 错误写法！ 线程销毁了 不能再调用。
    }

}
