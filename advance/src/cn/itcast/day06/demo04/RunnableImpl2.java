package cn.itcast.day06.demo04;

// 定义一个Runnable接口的实现类
public class RunnableImpl2 implements Runnable{

    // 覆盖重写Runnable中的run方法，并设置任务
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("HelloWorld" + i);
        }
    }
}
