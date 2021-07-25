package cn.itcast.day02.demo01;

import java.util.ArrayList;

/*
增强for循环：底层使用的也是迭代器，使用for循环的格式，简化的迭代器
JDK1.5之后出现的新特性
Collection<E>extends Iterable<E>：所有的单列集合都可以使用增强for
public interface Iterable<T>实现这个接口允许对象成为“foreach”语句的目标

增强for循环：用来遍历集合或数组，而且只能是集合或数组

格式：
    for (数据类型 变量名 : 容器(集合/数组)对象) {
        // 循环语句
    }
*/
public class Demo03Foreach {

    public static void main(String[] args) {
//        demo01();
        demo02();
    }

    // 遍历集合
    private static void demo02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (String s : list) {
            System.out.println(s);
        }
    }

    // 遍历数组
    private static void demo01() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int a : arr) {
            System.out.println(a);
        }
    }

}
