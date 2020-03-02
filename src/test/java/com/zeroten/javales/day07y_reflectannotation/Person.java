package com.zeroten.javales.day07y_reflectannotation;

import java.lang.annotation.*;
import java.util.Date;

// 使用注解
public class Person {

    private int id;

    public Person(@testAnn(value1="", value2="") int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Deprecated // 标注当前方法已过时
    public String myToString() {

        //        new Date().getDate();
//        new Date().getDay();
//        new Date().getMonth();

        return "Person{" +
                "id=" + id +
                '}';
    }
}

@SuppressWarnings("unused")
class A {
    void test(){
        int i;
    }
}

class B extends A {
    @Override
    void test() {

    }
}

// 定义注解
@Documented // 可要可不要，用于表明是否会出现在DOC里
@Target(ElementType.PARAMETER) // 可以没有 定义注解作用的地方
@Retention(RetentionPolicy.RUNTIME)  // 可无 定义注解的生命周期阶段
@interface testAnn {
    // 应当写一个类似于抽象方法
    String value1() default ""; // default ""; 设置默认值
    String value2();
}

interface C {
    public void test1();
    // 静态方法 java8 新特性  可重写，不能覆盖
    static void test2(){
        System.out.println("test2");
    }
    // 默认方法 java8 新特性
    default void test3() {
        System.out.println("test3");
    }
}