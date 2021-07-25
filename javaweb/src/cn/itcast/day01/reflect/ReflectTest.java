package cn.itcast.day01.reflect;

import cn.itcast.day01.domain.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    案例：
       需求：写一个“框架类”，不能改变任何类的任何代码的前提下，可以帮我们创建任意类的对象，并执行其中任意的方法
            实现：
                1.配置文件
                2.反射
            实现：
                1.将需要创建的对象的全类名和需要执行的方法在配置文件中
                2.在程序中加载读取配置文件
                3.使用反射技术来加载类文件进内存
                4.创建对象
                5.执行方法
*/

// 框架类
public class ReflectTest {

    // 框架类的实现
    public static void main(String[] args) throws Exception {
        /*
            类使用的两个步骤：
                1.创建对象
                2.调用方法
        */
        /*Person p = new Person();
        p.eat();*/

        // 1.将需要创建的对象的全类名和需要执行的方法在配置文件中
        // 配置文件：pro.properties

        /*
            2.在程序中加载读取配置文件
                java.util.Properties extends Hashtable<Object,Object>
                    Properties 类表示了一个持久的属性集
                        成员方法：String	getProperty(String key) 用指定的键在此属性列表中搜索属性          
        */
        // 2.1 创建Properties对象
        Properties pro = new Properties();
        // 2.2 创建ReflectTest的class对象
        Class rt = ReflectTest.class;
        // 2.3 加载配置文件，转换为一个集合
/*        InputStream is = new FileInputStream("/Users/app/Downloads/javaproject/javatest" +
                "/basic-code/javaweb/src/pro.properties"); // 也可以 但不推荐 */
        InputStream is = rt.getClassLoader().getResourceAsStream("pro.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.4 获取配置文件信息
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        // 3.使用反射技术来加载类文件进内存
        Class c = Class.forName(className);

        // 4.创建对象
        Object obj = c.newInstance();

        // 5.获取方法
        Method method = c.getMethod(methodName);

        // 6.执行方法
        method.invoke(obj);

    }

}
