package com.zeroten.javales.day66c_java8newfeatures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 函数式编程代码简化
 *
 */
public class SquareTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 用流的方式 将集合中每个元素平方
        List<Integer> reList = list.stream().map((e) -> e * e).collect(Collectors.toList());

        // 对每一个元素输出操作
        reList.stream().forEach((e) -> System.out.println(e));

    }

}
