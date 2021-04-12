package com.zeroten.javales.day64c_concurrentsemaphore;

public class Test {

    public static void main(String[] args) {

        Integer a = Integer.MAX_VALUE;
        Integer b = a + 1;

        System.out.println(a); // 2147483647
        System.out.println(b); // -2147483648 太大了会溢出 小于0

    }
}
