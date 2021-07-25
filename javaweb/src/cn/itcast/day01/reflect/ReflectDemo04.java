package cn.itcast.day01.reflect;

import cn.itcast.day01.domain.Person;

import java.lang.reflect.Method;

/*
    3.获取成员方法们

        Method：方法对象
            执行方法：
                Object	invoke(Object obj, Object... args) ：对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。
                    Object obj：真实的对象
                    Object... args：真实对象的参数 参数个数不固定
            获取方法名称：
                String	getName() ：以 String 形式返回此 Method 对象表示的方法名称。

     4.获取类名
            String	getName()：获取类名称
*/
public class ReflectDemo04 {

    /*
        获取成员方法们
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
    */
    public static void main(String[] args) throws Exception {
        // 获取Person的Class类对象
        Class pc = Person.class;
        // 获取指定名称的方法
        Method eat = pc.getMethod("eat");
        Person p = new Person();
        // 执行方法
        eat.invoke(p); // eat...

        // 获取有参数的eat方法
        Method eat2 = pc.getMethod("eat", String.class);
        eat2.invoke(p,"饭饭"); // eat...饭饭
        System.out.println("====================");

        // 获取所有public修饰的方法 (包括父类Object的方法)
        Method[] methods = pc.getMethods();
//        Method[] methods = pc.getDeclaredMethods(); // 可获取所有声明（定义）的方法，但不包括继承的方法
        for (Method method : methods) {
//            method.setAccessible(true); // 暴力反射
            // 获取方法名称
            System.out.println(method.getName());

            System.out.println(method);
        }

        // 获取类的名称
        String className = pc.getName();
        System.out.println(className); // cn.itcast.day01.domain.Person


    }

}
