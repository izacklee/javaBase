package cn.itcast.day13.demo01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/*
    使用Stream流的方式，遍历集合，对集合中的数据进行过滤
    Stream流是JDK1.8之后出现的
    关注的是做什么，而不是怎么做
*/
public class Demo02Stream {

    public static void main(String[] args) {
        // 1.创建一个list集合，存储姓名
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("赵强");
        list.add("张三丰");

        // 2.将list集合转换为Stream流
        Stream<String> stream = list.stream();
        // 3.对list集合进行过滤，只要以张开头的元素，存储到一个新的集合中
        // 4.对listA集合进行过滤，只要姓名长度为3的人，存储到一个新集合中
        // 5.遍历集合输出
        stream.filter(name->name.startsWith("张"))
              .filter(name->name.length() ==3)
              .forEach(name-> System.out.println(name));  // 最终输出结果和传统方式输出的一样
    }

}
