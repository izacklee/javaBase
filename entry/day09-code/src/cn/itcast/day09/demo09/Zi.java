package cn.itcast.day09.demo09;

/*
super关键字用来访问父类内容，而this关键字用来访问本类内容。用法也有三种：

1.在本类成员方法中，访问本类成员变量。
2.在本类成员方法中，访问本类另一个成员方法。
3.在本类构造方法中，访问本类另一个构造方法。

在第三种用法当中要注意：
A.this(...)调用也必须是构造方法的第一个语句，唯一一个。
B.super和this两种调用不能同时使用。
C.构造方法不能递归调用，但是成员方法可以。
*/
public class Zi extends Fu {
    int num = 10;

    public Zi() {
//        this(); // 错误写法！构造方法不能递归调用
//        super(); // 这一行不在赠送
//        this(10); // 本类的无参构造，调用本类的有参构造。
//        this(1, 2); // 错误写法！
    }
    public Zi(int num) {
        this(1, 2);
    }

    public Zi(int n, int m) {
        // 错误写法！（注：如果注释掉无参或者有参数的构造方法中的任何一个调用构造方法，则正确）
        // 构造方法中，无参的调一个参数的，一个参数的调两个参数的，两个参数的再调回无参的，会造成死循环。
//        this();
    }

    public void showNum() {
        int num = 10;
        System.out.println(num); // 局部变量
        System.out.println(this.num); // 本类的成员变量
        System.out.println(super.num); // 父类的成员变量

    }

    public void methodA() {
        System.out.println("AAA");
    }

    public void methodB() {
        // 本类成员方法中，调用本类另一个成员方法
        this.methodA();
        System.out.println("BBB");
    }
}
