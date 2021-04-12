package com.zeroten.javales.day71c_designpattern;

/**
 * 单例饿汉式和懒汉式
 */
public class SingletonTest {

    private SingletonTest() {
        // 饿汉式 未调用，执行main方法就直接把这句打印出来了
        System.out.println("单例加载。。。");
    }

//    // 饿汉式 静态的绑定在类上的 类触发静态成员变量也跟着触发
//    private static SingletonTest eHsingleton = new SingletonTest();
//
//    public static SingletonTest getEhSingleton() {
//
//        return eHsingleton;
//    }
//
    // 懒汉式 Dcl
    private static volatile SingletonTest singleton;

    public static SingletonTest getDclSingleton() {

        if (null == singleton) {

            synchronized (SingletonTest.class) {

                if (null == singleton) {

                    singleton = new SingletonTest();
                }
            }
        }

        return singleton;

    }

    // 懒汉式 静态内部类实现单例
    // 由类加载机制保证线程安全；相比Dcl方式，用静态内部类创建实例无法传参
    public static SingletonTest getStaticSingleton() {

        return HelperTest.SINGLETON_TEST;
    }

    private static class HelperTest {
        private static final SingletonTest SINGLETON_TEST = new SingletonTest();
    }

    public static void main(String[] args) {

//        System.out.println(SingletonTest.getDclSingleton());

        System.out.println(SingletonTest.getStaticSingleton());
    }
}
