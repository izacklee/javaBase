package cn.itcast.day05.demo04;

/*
    主线程：执行主（main）方法的线程

    单线程程序：Java中只有一个线程
    执行从main方法开始，从上到下依次执行

    JVM执行main方法，main方法会进入到栈内存
    JVM会找操作系统开辟一条main方法通向cpu的路径
    cpu就可以通过这个路径来执行main方法
    这个路径的名字叫：main（主）线程
*/
public class Demo01MainThread {

    public static void main(String[] args) {
        Person p1 = new Person("王丽坤");
        p1.run();
//        System.out.println(0/0); // 0不能做分母 java.lang.ArithmeticException: / by zero
        Person p2 = new Person("胡歌");
        p2.run();
    }
}
