package com.zeroten.javales.day66c_java8newfeatures;

import java.util.function.Predicate;

/**
 * 接口默认例子
 */
public class InterfaceDefaultTest {

    interface AbcInterface {

        int calc(int a, int b);

//        int print(int a);

        // default 关键字写法
        default int print(int a) {
            return a;
        }

    }

     static class TestA implements AbcInterface {

        @Override
        public int calc(int a, int b) {
            return a+b;
        }
    }

    class TestB implements AbcInterface {

        @Override
        public int calc(int a, int b) {
            return a-b;
        }
    }

    public static void main(String[] args) {

        new TestA().print(10);

    }
}
