package com.zeroten.javales.day05y_genericenum;

import java.util.ArrayList;
import java.util.List;

// 泛型的界限
public class Demo03Generic {

    public static void main(String[] args) {
        test(new ArrayList<Integer>());
    }
    // 范围上限 最大是自己
    // Number是一个抽象类 也是一个超类，所有的包装类都是Number的子类（如：Double,Float ...）
    public static void test(List<? extends Number> ls) {

    }
}
