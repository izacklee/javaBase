package cn.itcast.day07.demo03;

/*
    使用Runnable接口的方式实现多线程
*/
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
    }
}
