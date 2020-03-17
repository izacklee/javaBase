package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 阻塞队列
public class Demo05BlockingQueue {

    public static void main(String[] args) throws Exception{
        // 阻塞队列 可以理解为一个带线程操作的集合
        BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<>(3);

//        // put 阻塞
//        bqueue.put(1);
//        bqueue.put(1);
//        bqueue.put(1);
//        System.out.println("添加完毕");
//        bqueue.put(1);
//        System.out.println("多了一个");

//        // add 满了添加不进去，抛java.lang.IllegalStateException: Queue full异常
//        System.out.println(bqueue.add(1));
//        System.out.println(bqueue.add(1));
//        System.out.println(bqueue.add(1));
//        System.out.println("添加完毕");
//        System.out.println(bqueue.add(1));
//        System.out.println("多了一个");

        // offer 满了添加不进去，但不阻塞
        // 如果给固定长度队列设置值时，推荐使用
        System.out.println(bqueue.offer(1));
        System.out.println(bqueue.offer(1));
        System.out.println(bqueue.offer(1));
        System.out.println("添加完毕");
        System.out.println(bqueue.offer(1));
        System.out.println("多了一个");

    }
}
