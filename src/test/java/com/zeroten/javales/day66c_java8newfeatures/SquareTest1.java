package com.zeroten.javales.day66c_java8newfeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原代码
 * 例子：将一个数组中每个元素求平方，这段代码应该怎么写？
 */
public class SquareTest1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 创建一个新集合
        List<Integer> reList = new ArrayList<>();

        // 遍历集合
        for (Integer element : list) {
            // 将集合中每个元素平方存入新的集合
            reList.add(element * element);
        }

        // 遍历打印新集合
        for (Integer element : reList) {

            System.out.println(element);

        }
    }
}
