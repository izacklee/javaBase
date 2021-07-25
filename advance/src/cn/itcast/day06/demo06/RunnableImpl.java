package cn.itcast.day06.demo06;

/*
    卖票的案例
*/
public class RunnableImpl implements Runnable{
    // 定义一个多线程共享的票源
    private int ticket = 100;

    // 设置线程卖票
    @Override
    public void run() {
        // 使用死循环，让卖票操作重复执行
        while (true) {
            // 提高安全问题，用sleep让程序睡眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
                ticket--;
            }
        }
    }
}
