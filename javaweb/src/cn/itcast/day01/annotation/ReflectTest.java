package cn.itcast.day01.annotation;

import java.lang.reflect.Method;

/*
    在程序使用（解析）注解：获取注解中定义的属性值
        实现步骤：
            1.获取注解定义的位置的对象（Class，Method, Field）
            2.获取指定的注解
                getAnnotation(Pro.class)
                    其实就是在内存中生成了一个该注解接口的实现类对象
                    public class ProImpl implements Pro {
                        @Override
                        public String className() {
                            return "cn.itcast.day01.annotation.Demo01";
                        }

                        @Override
                        public String methodName() {
                            return "show";
                        }
                    }
             3.调用注解中的抽象方法获取配置的属性值
             4.使用反射技术加载类文件进内存
             5.创建对象
             6.获取方法
             7.执行方法
*/
// 框架类
@Pro(className = "cn.itcast.day01.annotation.Demo02", methodName = "show")
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        // 1.解析注解
        // 1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        // 2.获取上边的注解对象
        /*
            其实就是在内存中生成了一个该注解接口的实现类对象
            public class ProImpl implements Pro {
                @Override
                public String className() {
                    return "cn.itcast.day01.annotation.Demo01";
                }

                @Override
                public String methodName() {
                    return "show";
                }
            }

        */
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        // 3.调用对象中的抽象方法获取返回值
        String className = an.className();
        String methodName = an.methodName();
//        System.out.println(className);
//        System.out.println(methodName);

        // 4.使用反射技术加载类文件进内存
        Class c = Class.forName(className);

        // 5.创建对象
        Object obj = c.newInstance();

        // 6.获取方法
        Method method = c.getMethod(methodName);

        // 7.执行方法
        method.invoke(obj);

    }

}
