package cn.itcast.day06.demo09;

/*
    卖票案例出现了线程的安全问题
    卖出了不存在的或者重复的票

    解决线程安全问题的第三种方案：使用Lock锁
    java.util.concurrent.locks.Lock接口
    Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作。
    Lock接口中的方法：
        void lock()：获取锁。
        void unlock()：释放锁。
    java.util.concurrent.locks.ReentrantLock implements Lock接口

    使用步骤：
        1.在成员位置创建一个ReentrantLock对象
        2.在可以出现安全问题代码前，调用Lock接口中的lock方法获取锁
        3.在可能出现安全问题代码后，调用Lock接口中的lock方法释放锁

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
