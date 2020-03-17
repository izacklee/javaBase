package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo09AtomicManipulation {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        // 数据操作：读写改（新值/旧值）
        i.set(2);
        System.out.println(i.get()); // 2

        System.out.println(i.getAndSet(3)); // 2 返回旧值
    }
}
