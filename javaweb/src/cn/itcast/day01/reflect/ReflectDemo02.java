package cn.itcast.day01.reflect;

import cn.itcast.day01.domain.Person;

import java.lang.reflect.Field;

/*
    Class对象功能
        获取功能：
            1.获取成员变量们
                Field[]	getFields() ：获取所有public修饰的成员变量。
                Field	getField(String name) ：获取public修饰的指定成员变量。

                Field[]	getDeclaredFields() ：获取所有的成员变量，不考虑修饰符。
                Field	getDeclaredField(String name)：获取指定的成员变量，不考虑修饰符。

            2.获取构造方法们
                Constructor<?>[]	getConstructors()：
                    返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
                Constructor<T>	getConstructor(Class<?>... parameterTypes)：
                    返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。

                Constructor<?>[]	getDeclaredConstructors()：
                    返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。
                Constructor<T>	getDeclaredConstructor(Class<?>... parameterTypes)：
                    返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法。

             3.获取成员方法们
                Method[]	getMethods()：
                    返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口
                    （包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
                Method	getMethod(String name, Class<?>... parameterTypes)：
                    返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。

                Method[]	getDeclaredMethods()：
                    返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，
                    包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
                Method	getDeclaredMethod(String name, Class<?>... parameterTypes)：
                    返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法。

              4.获取类名
                 String	getName()：以 String 的形式返回此 Class 对象所表示的实体（类、接口、数组类、基本类型或 void）名称。

        Field：成员变量
            操作：
                1.设置值
                    void	set(Object obj, Object value)：将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
                2.获取值
                    Object	get(Object obj)：返回指定对象上此 Field 表示的字段的值。
                3.忽略访问权限修饰符的安全检查
                    setAccessible(true)：暴力反射
*/
public class ReflectDemo02 {

    public static void main(String[] args) throws Exception {
        // 获取Person的class对象
        Class cls = Person.class;

        /*
            1.获取成员变量们
                Field[]	getFields() ：获取所有public修饰的成员变量。
                Field	getField(String name) ：获取指定public修饰的成员变量。

                Field[]	getDeclaredFields() ：获取所有的成员变量，不考虑修饰符。
                Field	getDeclaredField(String name)：获取指定的成员变量，不考虑修饰符。
         */
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field a = cls.getField("a");
        System.out.println(a); // public int cn.itcast.day01.domain.Person.a

        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value); // null
        // 设置值
        a.set(p,"胡歌");
        // 获取值
        Object value2 = a.get(p);
        System.out.println(p); // Person{name='null', age=0, a='胡歌', b=0, c=0, sex='null', height=0}
        System.out.println(value2); // 胡歌

        System.out.println("----------------------");

        Field[] declaredFields = cls.getDeclaredFields();
        Field df2 = cls.getDeclaredField("height");
        for (Field df : declaredFields) {
            System.out.println(df);
        }
//        Object h = df2.get(p);
        // System.out.println(h); // cannot access a member of class cn.itcast.day01.domain.Person with modifiers "private"
        // 暴力反射 忽略访问权限修饰符的安全检查
        df2.setAccessible(true);
        Object h = df2.get(p);
        System.out.println(h);

        System.out.println("======================");


    }

}
