package cn.itcast.day13.demo01;

import java.util.ArrayList;

/*
    使用传统的方式，遍历集合，对集合中的数据进行过滤
*/
public class Demo01List {

    public static void main(String[] args) {
        // 创建一个list集合，存储姓名
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("赵强");
        list.add("张三丰");

        // 对list集合进行过滤，只要以张开头的元素，存储到一个新的集合中
        ArrayList<String> listA = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                listA.add(s);
            }
        }

        // 对listA集合进行过滤，只要姓名长度为3的人，存储到一个新集合中
        ArrayList<String> listB = new ArrayList<>();
        for (String s : listA) {
            if (s.length() == 3) {
                listB.add(s);
            }
        }

        // 遍历listB集合
        for (String s : listB) {
            /*
                张无忌
                张三丰
            */
            System.out.println(s);
        }
    }

}
