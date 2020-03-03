package com.zeroten.javales.day08y_reflectexception;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Demo01Reflect {

    public static void main(String[] args) throws Exception {
        // 使用反射，获取构造，并创建对象
        Class<?> c = Person.class;
        // 获取构造 通过参数列表来区分构造
        Constructor c1 = c.getConstructor();
        Constructor c2 = c.getConstructor(Integer.class);
        Constructor c3 = c.getConstructor(Integer.class, String.class, int.class);

        // 获取所有的构造
//        Constructor[] cs = c.getConstructors();
//        System.out.println(cs); // [Ljava.lang.reflect.Constructor;@5e481248

        // 获取参数列表
//        Annotation[][] pa = c3.getParameterAnnotations();
//        System.out.println(pa); //[[Ljava.lang.annotation.Annotation;@5e481248


        // 创建对象
        Object o = c1.newInstance(); // 调用0参构造
        Object o2 = c2.newInstance(1); // 调用1参构造
        Object o3 = c3.newInstance(2, "小凌", 18); // 调用3参构造

        // XML/流 --> 字符串（读取到的都是字符串，不存在其他类型数据）

        /*
            <Person id="1" age="" name="" class=""></Person>
            <Person id="2" age="" name="" class=""></Person>
            <Person id="3" age="" name="" class=""></Person>

        */
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        // {name:"", id:"", age:""}
        // keyset --> key
        String idKey = "id";
        String id ="1";
        String name = "ZackLee";
        String age = "18"; // 在不确定数据类型的情况下，字符串如何赋值到基本的数值类型
        String clazz = "com.zeroten.javales.day08y_reflectexception.Person";
        // {id:"", name:"", age:"", class:""}
        // 1.假设，我不知道对应属性的数据类型
        // 2.假设，我不知道对应属性叫什么
        // 3.赋值

        /*
        * 思路
        * 1.通过名字获取同名属性
        * 2.获取了同名属性，即获取该属性的类型
        * 3.判读是否是数值类型
        * */
//        Class pc = Person.class; // 在反射中看不到具体的类型
        Class pc = Class.forName(clazz); // 获取class
        Object obj = pc.newInstance();

//        Field f = Person.class.getDeclaredField("id");
        Field f = pc.getDeclaredField(idKey); // 获取到参数名 --> 得到属性对象
        // 判断（课后思考：如何验证是否是基本数据类型）---------- Number.class----> Integer.class
        Class<? extends Number> number = f.getType().asSubclass(Number.class);
//        System.out.println(number); // class java.lang.Integer
        if (number != null) {
            String setMethodName = "set" + f.getName().substring(0, 1).toUpperCase()
                    + f.getName().substring(1);
            Method setMethod = pc.getMethod(setMethodName, f.getType());
            // new Integer("");
            // number.getConstructor(String.class) 构造里的数据类型，由获取到的数据类型而定
            // 用构造最稳定  ----------- String.class----> int.class
            setMethod.invoke(obj,number.getConstructor(String.class).newInstance(id));

            String getMethodName = "get" + f.getName().substring(0, 1).toUpperCase()
                    + f.getName().substring(1);
            Method getMethod = pc.getMethod(getMethodName);
            Object invoke = getMethod.invoke(obj);
            System.out.println(invoke); // 1

        }
    }
}
