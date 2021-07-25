package cn.itcast.day05.demo05;

// 创建一个Thread类的子类
public class MyThread extends Thread{
    // 覆盖重写Thread父类的run方法，设置线程任务（开启线程要做什么？）
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run：" + i);
        }
    }

}
