package cn.itcast.day01.reflect;

import cn.itcast.day01.domain.Person;

import java.lang.reflect.Constructor;

/*
    2.获取构造方法们

        Constructor：构造方法
            创建对象：
                T	newInstance(Object... initargs)：
                    使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。

                如果使用的是空参数的构造方法创建对象，那么操作可简化为：使用Class类中的newInstance方法
*/

public class ReflectDemo03 {

    /*
        获取构造方法们
            Constructor<?>[]	getConstructors()：
                返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
            Constructor<T>	getConstructor(Class<?>... parameterTypes)：
                返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。

            Constructor<?>[]	getDeclaredConstructors()：
                返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。
            Constructor<T>	getDeclaredConstructor(Class<?>... parameterTypes)：
                返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法。
    */

    public static void main(String[] args) throws Exception {
        // 获取Person的Class对象
        Class p = Person.class;

        // Constructor<T>	getConstructor(Class<?>... parameterTypes)：获取public修饰的指定参数的构造方法
        Constructor cons = p.getConstructor(String.class, int.class);
        System.out.println(cons); // public cn.itcast.day01.domain.Person(java.lang.String,int)
        // T	newInstance(Object... initargs)：Constructor类中的用于创建对象的方法
        Object person = cons.newInstance("胡歌",28);
        System.out.println(person); // Person{name='胡歌', age=28, a='null', b=0, c=0, sex='null', height=0}
        System.out.println("================");

        // 使用空参数的构造方法创建对象
        Constructor cons2 = p.getConstructor();
        Object person2 = cons2.newInstance();
        System.out.println(person2); // Person{name='null', age=0, a='null', b=0, c=0, sex='null', height=0}
        // 可简化为Class类的newInstance方法
        Object person3 = p.newInstance(); // 其实就是访问构造器中内部的一个空参构造
        System.out.println(person3); // Person{name='null', age=0, a='null', b=0, c=0, sex='null', height=0}

       /* // 暴力反射 例子
        Constructor cons3 = p.getDeclaredConstructor(String.class, int.class);
        cons3.setAccessible(true); // 暴力反射
        Object person4 = cons3.newInstance("胡歌",28);
        System.out.println(person4); // Person{name='胡歌', age=28, a='null', b=0, c=0, sex='null', height=0}*/
    }

}
