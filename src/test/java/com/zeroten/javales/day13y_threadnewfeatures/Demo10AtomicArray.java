package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Demo10AtomicArray {
    public static void main(String[] args) throws Exception {
        Integer in = 12; // 公用变量
        AtomicIntegerArray ai = new AtomicIntegerArray(3); // 需要指定数组长度
        ai.getAndSet(0, 11);
        ai.getAndSet(1, 22);
        ai.getAndSet(2, 33);
//        ai.getAndSet(2, 11 + in); // 这种写法！！！不能保证公用变量in也是安全的
//        ai.getAndSet(3, 44); // java.lang.IndexOutOfBoundsException: index 3

    }
}
