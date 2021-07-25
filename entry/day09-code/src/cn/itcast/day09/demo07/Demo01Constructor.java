package cn.itcast.day09.demo07;

/*
继承关系中，父子类构造方法的访问特点：

1.子类构造方法当中有一个默认隐含的“super()”调用，所以一定是先调用父类的构造方法，后执行子类的构造方法。
2.子类构造方法可以通过super关键字来调用父类重载构造。
3.super的父类构造调用，必须是子构造方法的第一个语句。不能一个子构造方法里调用多次super构造。

总结：
子类继承父类，子类构造方法必须调用父类的构造方法，如果不写，编译器会自动赠送super(),写了则用指定的super调用。
super只能有一个，而且还必须是第一个。
*/
public class Demo01Constructor {
    public static void main(String[] args) {
        Zi zi = new Zi();
    }
}
