package cn.itcast.day07.demo01;

/*
    消费者（吃货）：是一个线程类，可以继承Thread
    设置线程任务（run）：吃包子
    对包子的状态进行判断
    false：没有包子
        吃货调用wait方法进入等待状态
    true：有包子
        吃货吃包子
        吃货吃完包子
        修改包子的状态为false没有
        吃货唤醒包子铺线程，生产包子

*/
public class ChiHuo extends Thread {

    // 包子的变量
    BaoZi bz;

    // 带有参数的构造方法，为这个包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    // 重写run方法 设置吃货线程任务
    @Override
    public void run() {
        // 一直吃包子
        while (true) {
            // 同步代码块
            synchronized (bz) {
                // 如果没有包子
                if (bz.flag == false) {
                    try {
                        bz.wait(); // 吃货调用wait方法进入等待状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货：正在吃" + bz.pi + bz.xian + "的包子");
                // 吃包子需要2秒
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = false;
                System.out.println("吃货：把"+ bz.pi + bz.xian + "的包子吃完了，包子铺需要再做包子");
                bz.notify(); // 唤醒包子铺，生产包子

                System.out.println("=====================================");
            }
        }
    }
}
