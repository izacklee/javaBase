package com.zeroten.javales.day07y_reflectannotation;

import java.lang.reflect.Field;

public class Demo03Reflect {

    public static void main(String[] args) throws Exception{
        // 1.获取属性（正常情况下属性都是私有的）
        Class s = Son.class;
        Object obj = s.newInstance();

        // 2.从类当中获取属性
//        Field f = s.getField("id"); // 获取共有属性 public
        Field f =  s.getDeclaredField("id"); // 获取所有属性对象
//        System.out.println(f);
        // 设置值
        f.setAccessible(true); // 是否允许通过反射访问私有目标
        f.set(obj, 1); // 给属性对象设置值，必须现有对象才能设置值
        // 取值
        Object id = f.get(obj);
        System.out.println(id); // 1

//        Field[] fs1 = s.getFields(); // 获取所有共有属性
//        Field[] fs2 = s.getDeclaredFields(); // 获取所有属性
//        System.out.println(fs2); // [Ljava.lang.reflect.Field;@66d3c617

    }
}
