package com.zeroten.javales.day66c_java8newfeatures;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Predicate函数式接口
 * 与或非的例子
 */

public class PredicateTest {

    public static void main(String[] args) {

//        Function<String, Integer> integer = (e) -> Integer.valueOf(9);  // 等于：Integer::valueOf; 写法

        // 一个整数 是否大于100 并且还要是偶数 并且还要能被8整除
        int a = 108;

        // 通常写法
//        if (a > 100) {
//
//            if (a % 2 == 0) {
//
//                if (a % 8 == 0) {
//
//                }
//
//            }
//
//        }

        Predicate<Integer> predicate = (e) -> e > 100;

        boolean b = predicate.and((e) -> e % 2 == 0).and((e) -> e % 8 == 0).test(a);
        boolean f = predicate.and((e) -> e % 2 == 0).or((e) -> e % 8 == 0).test(a);

        System.out.println(b); // false
        System.out.println(f); // true

    }

}
