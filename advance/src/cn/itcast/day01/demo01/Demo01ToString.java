package cn.itcast.day01.demo01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
java.lang.Object
    类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。
    所有对象（包括数组）都实现这个类的方法。
*/
public class Demo01ToString {
    public static void main(String[] args) {
        /*
            Person类继承了Object类，所以可以使用该类的toString方法
             String	toString() 返回该对象的字符串表示。
        */

        Person p = new Person("王丽坤", 18);
        // 直接打印对象名，其实就是调用了toString方法，也就是p.toString();
        // 判断toString方法是否已被覆盖重写，直接打印对象名查看即可
        // 打印返回地址值，则没有被覆盖重写
        // 打印返回被重写的方式，则已被覆盖重写
        System.out.println(p);
        System.out.println(p.toString());

        // 没有覆盖重写toString方法
        Random r = new Random();
        System.out.println(r); // java.util.Random@e580929

        // 覆盖重写了toString方法
        Scanner sc = new Scanner(System.in);
        System.out.println(sc); // java.util.Scanner[delimiters=\p{javaWhitespace}+][position=0]...

        // 也覆盖重写了toString方法
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list); // [1, 2]
    }
}
