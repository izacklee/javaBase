package cn.itcast.day09.demo04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    JDK9新特性
    try的前边可以定义流对象
    在try后边的()中可以直接引入流对象名（变量名）
    在try代码执行完毕之后，流对象也可以释放掉，不用在写finally
    格式：
        A a = new A();
        B b = new B();
        try (a;b) {
            // 可能会产生异常的代码
        } catch (异常类名 变量名) {
            // 异常处理逻辑
        }
*/
public class Demo03JDK9 {

    public static void main(String[] args) throws IOException {
        // 1.创建字节流输入对象
        FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day09/test/a.txt");
        // 2.创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("advance/src/cn/itcast/day08/test/b.txt");
        try (fis;fos) {
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

//        fos.write(97); //  错误写法！java.io.IOException: Stream Closed 流已经关闭
    }

}
