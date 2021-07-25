package cn.itcast.day07.demo01;

/*
    生产者（包子铺）类：是一个线程类，可以继承Thread
    设置线程任务(run)：生产包子
    对包子的状态进行判断
    true：有包子
        包子铺调用wait方法进入等待状态
    false：没有包子
        包子铺生产包子
        增加一些趣味性：交替生产两种包子
            有两种状态(%2==0)
        包子铺生产好了包子
        修改包子的状态为true有
        唤醒吃货线程，让吃货线程吃包子

    注意：
        包子铺线程和包子线程关系-->通信（互斥）
        必须同时同步技术保证两个线程只能有一个在执行
        锁对象必须保证唯一，可以使用包子对象作为锁对象
        包子铺类和吃货类就需要把包子作为对象传递进来
            1.需要在成员变量位置创建一个包子变量
            2.使用带有参数的构造方法，为这个包子变量赋值
*/
public class BaoZiPu extends Thread {
    // 包子的变量
    BaoZi bz;

    // 带有参数的构造方法，为这个包子变量赋值
    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    // 重写run方法 设置包子铺线程任务
    @Override
    public void run() {
        int count = 0;
        // 一直做包子
        while (true) {
            // 同步代码块
            synchronized (bz) {
                // 有包子
                if (bz.flag == true) {
                    try {
                        bz.wait(); // 包子铺调用wait方法进入等待状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count%2 ==0) {
                    bz.pi = "薄皮";
                    bz.xian = "韭菜肉";
                } else {
                    bz.pi ="冰皮";
                    bz.xian = "三鲜肉";
                }
                System.out.println("包子铺：正在生产" + bz.pi + bz.xian + "的包子");
                count++;
                // 生产包子需要3秒
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                bz.flag = true; // 更改包子状态为：true
                System.out.println("包子铺：" + bz.pi + bz.xian + "的包子已做好，顾客可以开吃了");
                bz.notify(); // 唤醒顾客吃包子
            }
        }
    }
}
