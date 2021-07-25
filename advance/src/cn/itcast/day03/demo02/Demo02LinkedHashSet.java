package cn.itcast.day03.demo02;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
java.util.LinkedHashSet集合 extends HashSet集合
LinkedHashSet集合特点：
    底层是一个哈希表（数组+链表/红黑树）+ 链表：多了一条链表（记录元素存储的顺序），保证元素有序
*/
public class Demo02LinkedHashSet {

    public static void main(String[] args) {
        // hashSet集合
        HashSet<String> set = new HashSet<>();
        set.add("hhh");
        set.add("aaa");
        set.add("bbb");
        System.out.println(set); // 无序  [aaa, bbb, hhh]

        // LinkedHashSet集合
        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("hhh");
        linked.add("aaa");
        linked.add("bbb");
        System.out.println(linked); // 有序 [hhh, aaa, bbb]
    }
}