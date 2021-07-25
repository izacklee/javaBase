package cn.itcast.day07.demo03;

/*
    使用Runnable接口的方式实现多线程程序 冗余的Runnable代码示例

    面向对象的思想：
        做一件事，只需要找到能解决这件事情的对象，然后调用对象的方法，完成这件事。
    函数式编程思想：
        只要能获取到结果，谁去做的，怎么做的都不重要，重视的是结果，不重视过程。
*/
public class Demo01Runnable {

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        // 开启线程
        new Thread(run).start();

        // 简化代码 使用匿名内部类实现多线程
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
            }
        };
        new Thread(r).start();

        // 再简化代码 使用匿名内部类匿名对象实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
            }
        }).start();

    }

}
