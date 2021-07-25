package cn.itcast.day06.demo10;

/*
    进入到TimeWaiting（计时等待有两种方式）
    1.使用sleep(long m)方法，在毫秒值结束之后，线程睡眠进入到Runnable/Blocked状态
    2.使用Wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来，线程睡眠进入到Runnable/Blocked状态

    唤醒的方法：
        void notify()：唤醒在此对象监视器上等待的单个线程
        void notifyAll()：唤醒在此对象监视器上等待的所有线程
*/
public class Demo02WaitAndNotifyAll {

    public static void main(String[] args) {
        // 创建锁的对象，保证唯一
        Object obj = new Object();

        // 顾客1线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 一直等待
                while(true) {
                    synchronized(obj) {
                        System.out.println("顾客1告知老板要的包子的种类和数量");
                        // 调用wait方法，放弃cpu执行，进入到WAITING状态（无限等待）
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子已经做好了，顾客1开吃");
                        System.out.println("=========================");
                    }
                }
            }
        }).start();

        // 顾客2线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 一直等待
                while(true) {
                    synchronized(obj) {
                        System.out.println("顾客2告知老板要的包子的种类和数量");
                        // 调用wait方法，放弃cpu执行，进入到WAITING状态（无限等待）
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子已经做好了，顾客2开吃");
                        System.out.println("=========================");
                    }
                }
            }
        }).start();

        // 老板线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 一直做包子
                while(true) {
                    try {
                        Thread.sleep(5000); // 花5秒做包子
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(obj) {
                        System.out.println("老板花了5秒做包子，包子做好后，告知顾客可以吃包子了");
                        // 调用notify方法，唤醒顾客吃包子
                        obj.notify(); // 如果有多个等待的线程，随机唤醒一个
                        obj.notifyAll(); // 可唤醒所有等待的线程
                    }
                }
            }
        }).start();

    }

}
