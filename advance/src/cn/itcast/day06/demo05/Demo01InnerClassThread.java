package cn.itcast.day06.demo05;

/*
    匿名内部类方式实现线程的创建

    匿名：没有名字
    内部类：写在方法内部的类

    匿名内部类作用：简化代码
        把子类继承父类，重写父类的方法，创建子类对象合成一步完成
        把实现类实现接口，重写接口的方法，创建接口实现类对象合成一步完成
    匿名内部类的最终产物：子类/实现类对象，而这个类没有名字

    格式：
        new 父类/接口() {
            重写父类/接口中的抽象方法
        }
*/
public class Demo01InnerClassThread {

    public static void main(String[] args) {
        // Thread线程
        // new 父类
        new Thread() {
            // 覆盖重写父类的run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("main:" + i);
                }
            }
        }.start();

        // 线程的接口
        // Runnable r = new RunnableImpl(); // 多态
        // new 接口
        Runnable r = new Runnable() {
            // 覆盖重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("runnable：" + i);
                }
            }
        };
        new Thread(r).start();

        // 简化代码  匿名内部类匿名对象的方式
        new Thread(new Runnable() {
            // 覆盖重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("anonymous：" + i);
                }
            }
        }).start();
    }

}
