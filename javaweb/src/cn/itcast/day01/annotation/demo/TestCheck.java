package cn.itcast.day01.annotation.demo;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    简单的测试框架
    当主方法执行后，会自动执行被检测的所有方法（加了Check注解的方法），判断是否有异常，记录到文件中

    小结：
        1.以后大多数时候，我们都会使用注解，而不是自定义注解
        2.注解给谁用？
            a.编译器
            b.给解析程序用（比如本类写的代码就是解析程序，如果没有的话加在方法上的@Chek注解将毫无意义）
        3.注解不是程序的一部分，可以理解为注解就是一个标签
*/
public class TestCheck {

    public static void main(String[] args) throws IOException {
        // 1.创建计算器类对象
        Calculator calculator = new Calculator();
        // 2.获取字节码文件对象
        Class cal = calculator.getClass();
        // 3.获取所有方法
        Method[] methods = cal.getMethods();
        BufferedWriter bw = new BufferedWriter(
                                    new FileWriter("javaweb/src/cn/itcast/day01/annotation/demo/bug.txt")
                            );
        int reasonNum = 0; // 出现异常的次数
        for (Method method : methods) {
            // 4.判断方法上是否有Check注释
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    // 5.有，执行
                    method.invoke(calculator);
                } catch (Exception e) {
                    // 6.捕获异常
                    String methodName = method.getName() + " 方法出现异常了！！！";
                    bw.write(methodName,0,methodName.length());
                    bw.newLine();

                    String name = "异常名称：" + e.getCause().getClass().getSimpleName();
                    bw.write(name,0 , name.length());
                    bw.newLine();

                    String reason = "异常原因：" + e.getCause().getMessage();
                    bw.write(reason, 0, reason.length());
                    bw.newLine();

                    bw.write("-----------------------------------");
                    bw.newLine();

                    reasonNum++;
                }
            }
        }
        if (reasonNum == 0) {
            bw.write("本次测试没有产生任何异常。");
            bw.newLine();
        } else {
            // 异常出现的次数
            bw.write("本次测试一共出现" + reasonNum + "次异常。");
            bw.newLine();

        }
        // 刷新缓冲区内容到文件中
        bw.flush();

        // 释放资源
        bw.close();

    }

}
