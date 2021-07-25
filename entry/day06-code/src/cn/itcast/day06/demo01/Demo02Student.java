package cn.itcast.day06.demo01;

import java.util.ArrayList;
import java.util.List;

/*
通常情况下，一个类并不能直接使用，需要根据类创建一个对象才能使用。

1.导包：也就是指出需要使用的类，在什么位置。
    import 包名称.类名称
    import cn.itcast.day06.demo01.Student
    对于和当前类同一个包的情况下，可以省略导包语句不写。
2.创建，格式：
    类名称 对象名 = new 类名称();
    Student stu = new Student();
3.使用，分两种情况：
    使用成员变量：对象名.成员变量名
    使用成员方法：对象名.成员方法名(参数);
    （也就是，想用谁就用对象名点谁。）
*/
public class Demo02Student {
    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println(stu.name); // null
        System.out.println(stu.age); // 0

        System.out.println("========");

        stu.name = "迪丽热巴";
        stu.age = 18;

        System.out.println(stu.name); // 迪丽热巴
        System.out.println(stu.age);  // 18

        System.out.println("============");

        stu.eat(); // 吃饭
        stu.sleep(); // 睡觉
        stu.study(); // 学生

        System.out.println("===============");

        // 以下是扩展
        // Java的别名机制
        Student stu2 = new Student();
        Student stu3 = new Student();
        stu2.name="1";
        stu3.name ="2";
        System.out.println(stu2); // cn.itcast.day06.demo01.Student@5fe5c6f
        System.out.println(stu3); // cn.itcast.day06.demo01.Student@6979e8cb
        System.out.println("stu2：" + stu2.name + " ----  stu3：" + stu3.name); // stu2：1 ----  stu3：2
        // stu3把内存地址赋值给stu2之后 stu2实际上就等于stu3
        stu2 = stu3;
        System.out.println(stu2); // cn.itcast.day06.demo01.Student@6979e8cb
        System.out.println(stu3); // cn.itcast.day06.demo01.Student@6979e8cb
        // 把stu3的值改之后 自然stu2的值也被改
        stu3.name = "3";
        System.out.println("stu2：" + stu2.name + " ----  stu3：" + stu3.name); // stu2：3 ----  stu3：3

        // 赋值就是把一个引用的地址指向了另外一个地址~然后它的值就是这个地址的值。
        // 也就是说，如果你的对象都是同一地址，那么改变该地址的值，另外一个同地址的对象也会改变。
        // 比如
        List a = new ArrayList();
        a.add("a");
        // 这里边的a、b就是同一地址；
        List b=a;
        b.add("b");
        System.out.println(a); // [a, b]

        // 但是有赋值的则不会如此：
        String a2="a";
        String b2=a2;
        System.out.println(a2); // a
        System.out.println(b2); // a
//        b2=a2; 这个写法和上一步结果一样
        b2="b";
        System.out.println(b2); // b
        // 这里边b的引用虽然指向了a，但是后来的赋值让它指向了新的地址，改变的不是原来地址的值；所以a没有改变。
        System.out.println(a2);//output:a

        // 你的哥哥弟弟必须是两个地址不同的对象 这样的；
        Student brotherA = new Student();
        Student brotherB = new Student();

        System.out.println(brotherA); // cn.itcast.day06.demo01.Student@27f674d
        System.out.println(brotherB); // cn.itcast.day06.demo01.Student@1d251891
        brotherA.name = "1";
        brotherB.name = "2";
        // 如果你一定要弟弟继承哥哥的属性，你可以在Student中实现implements Cloneable接口，并且重写clone方法
        // 这样brotherA和brotherB都一样且改变brotherB/A都不会影响另外一个。
        brotherB =(Student)brotherA.clone();
        brotherB.name = "3";
        System.out.println(brotherA); // cn.itcast.day06.demo01.Student@27f674d
        System.out.println(brotherB); // cn.itcast.day06.demo01.Student@48140564
        System.out.println(brotherA.name + "==" + brotherB.name); // 1==3
    }
}
