package cn.itcast.day01.reflect;

import cn.itcast.day01.domain.Person;

import java.util.Arrays;
import java.util.Scanner;

/*
    Java程序的三个阶段：Source源代码阶段、Class类对象阶段、Runtime运行时阶段。

    反射：框架设计的灵魂
        框架：半成品软件。可以在框架的基础上进行软件开发，简化编码
        反射：将类的各个部分封装成其他对象，这就是反射机制
            好处：
                1.可以在程序运行过程中，操作这些对象
                2.可以解耦，提高程序的扩展性

        获取Class对象的方式：
            1.Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
                多用于配置文件，将类名定义在配置文件中。读取文件，加载类。
            2.类名.class：通过类名属性的class获取
                多用于参数的传递
            3.对象.getClass()：getClass()方法在Object类中定义着
                多用于对象的获取字节码的方式

        结论：同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，不论是通过哪种方式获取Class的对象都是同一个。
*/
public class ReflectDemo01 {

    public static void main(String[] args) throws Exception {

        // 1.Class.forName("全类名")
        Class cls1 = Class.forName("cn.itcast.day01.domain.Person");
        System.out.println(cls1); // class cn.itcast.day01.domain.Person

        // 2.类名.class
        Class cls2 = Person.class;
        System.out.println(cls2); // class cn.itcast.day01.domain.Person

        // 3.对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3); // class cn.itcast.day01.domain.Person

        // ==比较三个对象
        // 同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，不论是通过哪种方式获取Class的对象都是同一个。
//        boolean e1 = cls1.equals(cls2);
//        boolean e2 = cls1.equals(cls3);
        System.out.println(cls1 == cls2); // true
        System.out.println(cls1 == cls3); // true

    }
}
