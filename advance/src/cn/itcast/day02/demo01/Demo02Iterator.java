package cn.itcast.day02.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
java.util.Iterator接口：迭代器（对集合进行遍历）
有两个常用的方法：
    boolean	hasNext() ：【判断集合是否有下一个元素】如果仍有元素可以迭代，则返回 true。
    E	next()：【获取集合中的下一个元素】返回迭代的下一个元素。
Iterator迭代器，是一个接口，无法直接使用，需要使用Iterator接口的实现类对象，获取实现类的对象比较特殊
Collection接口中有一个iterator()方法，调用这个方法返回的就是迭代器实现类的对象
    Iterator<E>	iterator() ：返回在此 collection 的元素上进行迭代的迭代器。

迭代器的使用步骤（重点）：
    1.使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）
    2.使用Iterator接口中的hasNext方法，判断是否还有下一个元素
    3.使用Iterator接口中的next方法，取出集合中的下一个元素
*/
public class Demo02Iterator {

    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("科比");
        coll.add("詹姆斯");
        coll.add("艾弗森");

        // 获取迭代器（多态）
        // 接口                     实现类
        Iterator<String> it = coll.iterator();

        /*
           不知道集合中元素的个数用while循环
           循环结束的条件，hasNext方法返回false
        */
        while (it.hasNext()) {  // 判断集合是否还有下一个元素
            String str = it.next(); // 1.获取集合中的下一个元素；2.把指针往下一个元素移动
            System.out.println(str);
        }

        System.out.println("============");

        // for循环 【了解】
        for (Iterator<String> it1 = coll.iterator(); it1.hasNext();) {
            String str1 = it1.next();
            System.out.println(str1);
        }
    }

}
