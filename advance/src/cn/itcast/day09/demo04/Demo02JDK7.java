package cn.itcast.day09.demo04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
    JDK7的新特性
    在try的后边可以增加一个()，在括号中可以定义流对象
    那么这个流对象的作用域就在try中有效
    try中的代码执行完毕，会自动把流对象释放，不用写finally
    格式：
        try (定义流对象1;定义流对象2...) {
            // 可能会产生异常的代码
        } catch (异常类名 变量名) {
            // 异常处理逻辑
        }
*/
public class Demo02JDK7 {

    public static void main(String[] args) {
        try (// 1.创建字节流输入对象
             FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day09/test/a.txt");
             // 2.创建字节输出流对象
             FileOutputStream fos = new FileOutputStream("advance/src/cn/itcast/day08/test/b.txt")) {

            // 3.读取文件
            int len = 0;
            while ((len = fis.read()) != -1) {
                System.out.print(len + ","); // 97,98,99,101,102,103,104,100,  返回字节数
                // 4.写入文件
                fos.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
