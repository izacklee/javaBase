package cn.itcast.day07.demo01;

import java.util.Scanner;
/*
Scanner类的功能：可以实现键盘输入数据，到程序当中。

引用类型的一般使用步骤：
    1.导包
        import 包的路径.类名称
        如果需要使用的目标类和当前类在同一个包下，那么可以省略掉导包语句
        只有java.lang包下的内容不需要导包，其他的都需要import语句。
    2.创建
        类名称 对象名 = new 类名称();
    3.使用
        对象名.成员方法名称();

获取键盘输入的一个int类型，int num = sc.nextInt();
获取键盘输入的一个字符串类型，String str = sc.next();
备注：从键盘输入的int类型数字，用sc.nextInt()获取到的其实是字符串，
     只是经过编译处理后转为int型输出。
*/
public class Demo01Scanner {
    public static void main(String[] args) {
        // 1.创建
        // System.in代表从键盘进行输入
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数字：");
        int num = sc.nextInt();
        System.out.println("您输入的数字是：" + num);

        System.out.println("============");

        System.out.print("请输入一个字符串：");
        String str = sc.next();
        System.out.println("您输入的字符串是：" + str);
    }
}
