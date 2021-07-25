package cn.itcast.day07.demo05;

/*
题目：定义以指定格式打印集合的方法（ArrayList类型作为参数），使用{}括起来，使用@分隔每个元素。
格式参照{元素@元素@元素}。

System.out.println(list);     [10, 20, 30]
printArrayList(list);         {10@20@30}
*/

import java.util.ArrayList;

public class Demo03ArrayListPrint {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list); //[10, 20, 30]
        printArrayList(list);
    }

    /*
       格式化数组方法
       方法三要素：
            返回值类型：只是打印而已，没有运算，没有结果，所以用void
            方法名称：printArrayList
            参数列表：ArrayList
    */
    public static void printArrayList(ArrayList<Integer> list) {
        // {10@20@30}
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            // 如果是最后一个元素，则内容拼接上右大括号：}
            if (i == list.size()-1) {
                System.out.println(list.get(i) + "}");
            } else {
                System.out.print(list.get(i) + "@");
            }
        }
    }
}
