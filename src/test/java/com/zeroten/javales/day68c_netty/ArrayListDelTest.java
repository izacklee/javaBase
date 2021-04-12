package com.zeroten.javales.day68c_netty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDelTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i=0; i<10; i++) {

            if (i<5)
                list.add("1");
            else if (i<8)
                list.add("5");
            else
                list.add(i+"");
        }

        print(list); // 1,1,1,1,1,5,5,5,8,9

//        // 2 有重复数据就不对了
//        for (int i=0; i<list.size(); i++) {
//
//            if (list.get(i).equals("1") || list.get(i).equals("5")) {
//                // 原：1,1,1,1,1,5,5,5,8,9
//                // 第一次删除后：1,1,1,1,5,5,5,8,9
//                // 此时i为1了，删除后新的集合i为0的就无法找到，如此下去结果就不断被漏删了
//                list.remove(i);  // 会漏删除 因为i是递增的 而list.size是变小的
//
//            }
//
//        }

//        // 3 递减删除 正确（递减删除和迭代器删除都正确（因迭代器内部也做过处理的））
//        for (int i=list.size()-1; i>=0; i--) {
//
//            if (list.get(i).equals("1") || list.get(i).equals("5")) {
//
//                list.remove(i);
//
//            }
//
//        }

        // 8 迭代器 正确
        for(Iterator<String> iter = list.iterator(); iter.hasNext();)  {
            String str = iter.next();
            if (str.equals("1") || str.equals("5")) {
                iter.remove();
            }
        }


        print(list); // 2的结果：,1,5,5,8,9；3的结果： 8,9

    }

    private static void print(List<String> list) {

        StringBuilder sb = new StringBuilder();

        for (String e : list) {
            sb.append(e).append(",");
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());
    }

}
