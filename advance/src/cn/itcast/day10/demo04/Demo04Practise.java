package cn.itcast.day10.demo04;

import java.io.*;

/*
    练习：转换文件编码
        将GBK编码的文本文件，转换为UTF-8编码的文本文件

    思路：
        1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
        2.创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称UTF-8
        3.使用InputStreamReader对象中的read方法，读取文件
        4.使用OutputStreamWriter对象中的write方法，把读取到的数据写入到文件中
        5.释放资源
*/
public class Demo04Practise {

    public static void main(String[] args) throws IOException {
        // 1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("advance/src/cn/itcast/day10/test/gbk.txt"),"GBK");
        // 2.创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称UTF-8
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("advance/src/cn/itcast/day10/test/gbkzhuanutf8.txt"),"UTF-8");
        // 3.使用InputStreamReader对象中的read方法，读取文件
        char[] c = new char[1024];
        int len = 0;
        while ((len = isr.read(c)) != -1) {
            // 4.使用OutputStreamWriter对象中的write方法，把读取到的数据写入到文件中
            osw.write(c,0, len);
        }
        // 5.释放资源
        osw.close();
        isr.close();
    }

}
