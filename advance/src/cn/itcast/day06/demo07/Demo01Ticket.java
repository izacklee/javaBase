package cn.itcast.day06.demo07;

/*
    卖票案例出现了线程的安全问题
    卖出了不存在的或者重复的票

    解决线程安全问题的第一种方案：使用同步代码块
    格式：
        synchronized(锁对象) {
            可能会出现线程安全问题的代码（访问了共享数据的代码）
        }
    注意：
        1.通过代码块中的锁对象，可以使用任意的对象
        2.但必须保证多个线程使用的锁对象是同一个
        3.锁对象的作用：
            把同步代码块锁住，只让一个线程在同步代码块中执行
*/
public class Demo01Ticket {

    public static void main(String[] args) {
        RunnableImpl r = new RunnableImpl();
        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        // 3线程 同时开启
        t0.start();
        t1.start();
        t2.start();
    }

}
