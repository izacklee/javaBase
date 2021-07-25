package cn.itcast.day06.demo01;

public class MyThread extends Thread{

    @Override
    public void run() {
        // 获取线程的名称
//        String name = getName();
//        System.out.println(name);
//        另一种获取线程名称的方法
        System.out.println(Thread.currentThread().getName());
    }
}
