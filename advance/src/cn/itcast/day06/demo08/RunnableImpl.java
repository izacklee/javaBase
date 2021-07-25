package cn.itcast.day06.demo08;

/*
    卖票的案例
*/
public class RunnableImpl implements Runnable{
    // 定义一个多线程共享的票源
//    private int ticket = 100;
    private static int ticket = 100;

    Object obj = new Object();

    // 设置线程卖票
    @Override
    public void run() {
        // 使用死循环，让卖票操作重复执行
        while (true) {
//            payTicket();
//            payTicket2();
            payTicketStatic();
        }
    }

    // 定义一个同步方法
    /*
        同步方法也会把方法内部代码锁住
        只让一个线程执行
        同步代码锁的对象是实现类 new RunnableImpl()
        也就是this（看payTicket2()方法例子）
    */
    public synchronized void payTicket() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
            ticket--;
        }
    }

    /*
        用this作为锁的对象
    */
    public void payTicket2() {
        synchronized (this) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票.");
                ticket--;
            }
        }
    }

    /*
        静态的同步方法
        锁的对象不能是this
        this是创建对象之后产生的，静态方法优先于对象
        静态方法的锁对象是本类的class属性-->class文件对象（反射）
        写法：RunnableImpl.class
    */
    public static /*synchronized*/ void payTicketStatic() {
        synchronized (RunnableImpl.class) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票s");
                ticket--;
            }
        }
    }
}
