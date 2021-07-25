package cn.itcast.day06.demo02;

/*
    设置线程的名称：（了解）
        1.使用Thread类中的方法setName(名字)。
            void SetName(String name)：改变线程的名字，使之与参数name相同。
        2.创建一个带参数的构造方法，参数传递线程的名称，调用父类带参数的构造方法，把线程的名称传给父类，
            让父类（Thread）给子线程取一个名字。
            Thread (String name)：分配新的Thread对象。
*/
public class Demo01SetThreadName {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
//        Thread.currentThread().setName("main线程1");
        mt.setName("main线程1");
        new MyThread("main线程2").start();

//        System.out.println(Thread.currentThread().getName());
        mt.start();
    }

}
