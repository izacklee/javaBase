package com.zeroten.javales.day08y_reflectexception;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Demo02Annotation {

    public static void main(String[] args) {

        // 通过反射获取注解
        // 注解可以获取你在注解中填的值
        Class<MyClass> mc = MyClass.class;
        // 获取注解
        MyAnn ann = (MyAnn) mc.getAnnotation(MyAnn.class);
        System.out.println(ann.f1());
        System.out.println(ann.f2());

    }
}

@Retention(RetentionPolicy.RUNTIME)  // 必须定义 否则注解获取不到
@interface MyAnn {
    String f1() default "";
    String f2() default "";
}

@MyAnn(f1="testf1",f2="testf2")
class MyClass {

}
