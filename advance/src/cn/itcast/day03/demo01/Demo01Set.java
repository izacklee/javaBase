package cn.itcast.day03.demo01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
java.util.Set接口 extends Collection接口
Set接口的特点：
    1.不允许存储重复的元素
    2.没有索引，没有带索引的方法，也不能使用普通的for循环遍历

java.util.HashSet集合 implements Set接口
HashSet实现类：
    1.不允许存储重复的元素
    2.没有索引，没有带索引的方法，也不能使用for循环
    3.是一个无序集合，存储元素和取出元素的顺序可能不一致
    4.底层是一个哈希表结构（查询快，增删快，但不允许重复）
*/
public class Demo01Set {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        // 使用add方法忘集合中添加元素
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);

        System.out.println(set); // [1, 2, 3] 无重复元素

        // 使用Iterator迭代器遍历集合
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int in =it.next();
            System.out.println(in);
        }

        System.out.println("==============");

        // 使用增强for循环遍历
        for (Integer i :set) {
            System.out.println(i);
        }
    }

}
