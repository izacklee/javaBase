package com.zeroten.javales.day10y_thread;

// 非静态同步
public class Demo07ThreadSynchronized {

    public static void main(String[] args) {
        int total = 0;
        for (int i=0; i<20; i++) {
            total += new B().test1();
            System.out.println(total);
        }
    }
}
class C {
    int test(int i) {
        return ++i;
    }
}
class B {
    private C c = new C();
    private int i = 1;
    // 同步方法
    public synchronized int test1() {
//        this.notifyAll(); // 不能唤醒test2的c 因同步的对象不一样
        return ++i;
    }

    // 同步代码块
    public int test2() {
        Object object = new Object(); // 对数据本身没有任何影响得，可以写在外面
        synchronized(c) {
            try {
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return c.test(i);
        }

        // return i++; {读。。。} 不可以写在外面
    }

}
