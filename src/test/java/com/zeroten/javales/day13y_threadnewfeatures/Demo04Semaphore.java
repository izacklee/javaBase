package com.zeroten.javales.day13y_threadnewfeatures;

import java.util.concurrent.Semaphore;

// 信号量
public class Demo04Semaphore {

    public static void main(String[] args) throws Exception {
        // 只要信号量没满，就可以一直加，如果满了，就加不了了
        Semaphore sp = new Semaphore(10); // 信号量
        sp.acquire(5); // +5
        System.out.println(5); // 5

        sp.acquire(3); // + 3
        System.out.println(8); // 8

        sp.release(4); // -4
        System.out.println(4); // 4

        sp.acquire(3); // +3
        System.out.println(7); // 7
    }
}
