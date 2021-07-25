package cn.itcast.day06.demo07;

/*
    卖票的案例
*/
public class RunnableImpl implements Runnable{
    // 定义一个多线程共享的票源
    private int ticket = 100;
    Object obj = new Object();

    // 设置线程卖票
    @Override
    public void run() {
        // 使用死循环，让卖票操作重复执行
        while (true) {
            // 同步代码块
            synchronized(obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
                    ticket--;
                }
            }
        }
    }
}
