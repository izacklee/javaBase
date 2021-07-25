package cn.itcast.day09.demo03;

import java.io.FileReader;
import java.io.IOException;

/*
    java.io.Reader：字符输入流，是字符输入流最顶层的父类，是抽象类，定义了一些成员方法。

    共性的成员方法：
        public int read() : 读取单个字符并返回。
        public int read(char[] cbuf) : 一次读取多个字符，将字符读入数组。
        public void close() :关闭此流并释放与此流相关联的任何系统资源。

   java.io.FileReader extends InputStreamReader extends Reader
   FileReader：文件字符输入流
        作用：把硬盘中的数据以字符的方式读取到内存中

   构造方法：
        FileReader(String fileName)：在给定从中读取数据的文件名的情况下创建一个新 FileReader。
        FileReader(File file)：在给定从中读取数据的 File 的情况下创建一个新 FileReader。
        参数：读取文件的数据源
            String FileName：文件路径
            File file：一个文件
        FileReader构造方法的作用：
            1.创建一个FileReader对象
            2.会把FileReader对象指向要读取的文件

   字符输入流的使用步骤：
        1.创建一个FileReader对象，构造方法中传递数据源
        2.使用FileReader对象的read方法，读取文件
        3.释放资源
*/
public class Demo01Read {

    public static void main(String[] args) throws IOException {
        // 1.创建FileReader对象
        FileReader fr = new FileReader("advance/src/cn/itcast/day09/test/a.txt");
        // 2.读取文件 读取单个字符方式
//        int len = 0;
//        while ((len = fr.read()) != -1) {
//            System.out.print((char)len); // abcefghd你好吗？
//        }
        // 一次读取多个字符
        char[] c = new char[1024];
        int len = 0; // 记录字符每次读取的有效个数
        while ((len = fr.read(c)) != -1) {
            // String(char[] value, int offset, int count)：分配一个新的 String，它包含取自字符数组参数一个子数组的字符
            System.out.println(new String(c,0,len));
        }

        // 3.释放资源
        fr.close();
    }

}
