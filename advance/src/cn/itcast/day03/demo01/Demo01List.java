package cn.itcast.day03.demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
java.util.List接口 extends Collection接口
List接口的特点：
    1.有序的集合，存储元素和取出元素是顺序一致的（存储123 取出123）
    2.有索引，包含了一些带索引的方法
    3.允许存储重复的元素

List 接口中常用的方法（特有）:
    public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
    public E get(int index) :返回集合中指定位置的元素。
    public E remove(int index) : 移除列表中指定位置的元素, 返回的是被移除的元素。
    public E set(int index, E element) :用指定元素替换集合中指定位置的元素,返回值的更新前的元素。

注意：
    操作索引的时候，一定要防止索引越界异常
    IndexOutOfBoundsException：索引越界异常，集合会报错
    ArrayIndexOutOfBoundsException：数组索引越界异常
    StringIndexOutOfBoundsException：字符串索引越界异常

许多程序员开发时非常随意地使用ArrayList完成任何需求，并不严谨，这种用法是不提倡的。
数组：查询快，增删慢
链表：查询慢，增删快
list底层是数组，所以根据需求再对比其特性使用。
*/
public class Demo01List {

    public static void main(String[] args) {
        // 左父右子 多态
        List<String> list = new ArrayList<>();
        list.add("科比");
        list.add("詹姆斯");
        list.add("艾佛森");

        System.out.println(list); // [科比, 詹姆斯, 艾佛森]

        // list集合遍历的3种方式
        // for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("==========");

        // 使用迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("===========");

        // 使用增强for遍历
        for (String s : list) {
            System.out.println(s);
        }

        // System.out.println(list.get(3)); // 错误！只有三个元素，索引越界 报：IndexOutOfBoundsException
    }
}
