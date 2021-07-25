package cn.itcast.day06.demo05;

/*
一个标准的类通常要有下面四个部分组成：
    1.所有的成员变量都要有private关键字修饰
    2.所有的成员变量都要编写一对getter/setter方法
    3.编写一个无参数的构造方法
    4.编写一个全参数的构造方法

这样的标准也叫Jave Bean
*/

public class Student {
    private String name; // 姓名
    private int age; // 年龄

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
