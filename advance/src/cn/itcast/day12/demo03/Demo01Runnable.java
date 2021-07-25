package cn.itcast.day12.demo03;

/*
     例如 java.lang.Runnable 接口就是一个函数式接口，
     假设有一个 startThread 方法使用该接口作为参数，那么就 可以使用Lambda进行传参。
     这种情况其实和 Thread 类的构造方法参数为 Runnable 没有本质区别。
*/
public class Demo01Runnable {

    public static void main(String[] args) {
        // 调用startThread方法，参数使用匿名内部类方式
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        // 调用startThread方法，使用Lambda表达式
        startThread(()-> System.out.println(Thread.currentThread().getName()));
    }

    // 定义一个startThread方法，方法的参数是Runnable
    public static void startThread(Runnable run) {
        // 开启多线程
        new Thread(run).start();
    }

}
