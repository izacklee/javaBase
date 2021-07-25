package cn.itcast.day06.demo06;

/*
    模拟卖票案例
    创建3个线程，同时开启，对票进行出售
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
