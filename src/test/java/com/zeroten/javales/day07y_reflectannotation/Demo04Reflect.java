package com.zeroten.javales.day07y_reflectannotation;

import oracle.jrockit.jfr.StringConstantPool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo04Reflect {

    public static void main(String args[]) throws Exception {
        // 反射操作方法
        Class s = Son.class;
        Object obj = s.newInstance();

        // getter/setter
        // 假设循环到该属性，假设我不知道属性名
        Field f = s.getDeclaredField("id");
        String fieldName = f.getName();
//        System.out.println(fieldName);

        // setId
        String setMethodName = "set" + fieldName.substring(0,1).toUpperCase()
                                    + fieldName.substring(1).toLowerCase();
        // 多参数
//        Method setMethod = s.getMethod(setMethodName,f.getType(), int.class,String.class);

        Method setMethod = s.getMethod(setMethodName,f.getType());
        // public void com.zeroten.javales.day07y_reflectannotation.Son.setId(int)
//        System.out.println(setMethod);
//        System.out.println(f.getType()); // int

        // 多参数传值
//        Object r = setMethod.invoke(obj, 1, 1, "test");

        Object r = setMethod.invoke(obj, 1);

//        System.out.println(r); // null

        // getId
        String getMethondName = "get" + fieldName.substring(0,1).toUpperCase()
                                     + fieldName.substring(1).toLowerCase();
        Method getMethod = s.getMethod(getMethondName);

        Object r2 = getMethod.invoke(obj);
        System.out.println(r2); // 1



    }

}
