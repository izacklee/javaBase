package com.zeroten.javales.day72c_designpattern;

import java.util.*;

/**
 * 迭代器模式应用案例
 */
public class IteratorTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // 增强for
//        for (Integer l : list) {
//
//            System.out.println(l);
//        }

        // 迭代器
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }

        // hashMap迭代器的用法
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        Iterator var4 = map.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) var4.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
