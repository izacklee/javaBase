package com.zeroten.javales.day70c_designpattern;

/**
 * 单例正确案例
 */
public class SingletonTest {

    // 构造函数私有，防止外部直接new
    private SingletonTest() {}

    // 给变量加上volatile，防止重排序
    private static volatile SingletonTest singletonTest;

    public static SingletonTest getSingleton() {

        if (null == singletonTest) {

            synchronized (SingletonTest.class) {

                if (null == singletonTest) {

                    // 正常执行顺序：1、2、3，不加volatile时可能就是1、3、2，
                    // 结果可能就导致返回的对象不完全，没初始化，用的时候可能就出问题了
                    singletonTest = new SingletonTest(); // 1 堆上分配空间；2 初始化；3 地址赋值。
                }

            }
        }

        return singletonTest;

    }

    public static void main(String[] args) {

    }

}
