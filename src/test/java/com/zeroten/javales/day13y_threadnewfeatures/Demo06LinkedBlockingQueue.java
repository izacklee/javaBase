package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

// 阻塞栈
public class Demo06LinkedBlockingQueue {

    public static void main(String[] args) throws Exception{
        BlockingDeque<Integer> bDeque = new LinkedBlockingDeque<>(2);
        bDeque.addFirst(1); // 向第一个位置添加元素
        bDeque.takeFirst(); // 把第一个位置元素删除
        System.out.println(bDeque); // []
    }
}
