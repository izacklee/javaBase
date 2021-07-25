package cn.itcast.day09.demo01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    字节输入流一次读取多个字节的方法：
        public int read(byte[] b) : 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。
    明确两件事情：
        1.方法的参数byte[]的作用？
            起到缓冲作用，存储每次读取到的多个字节
            数组的长度一般定义为1024(1kb)或者1024的整数倍
        2.方法返回值int是什么？
            每次读取的有效字节个数

    String类的构造方法：
        String(byte[] bytes)：通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
        String(byte[] bytes, int offset, int length)：通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。
            把字节数组的一部分转换为字符串 offset：数组的开始索引 length：转换的字节个数
*/
public class Demo05InputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day09/test/a.txt");
        /*byte[] bytes = new byte[2]; // 字节数组的长度大于文件字节的长度时，打印输出new String(bytes)有多余的空格
        int len = fis.read(bytes);
        System.out.println(len); // 2
        System.out.println(Arrays.toString(bytes)); // [97, 98]
        System.out.println(new String(bytes)); // ab
        // 把字节数组的一部分转换为字符串
        System.out.println(new String(bytes, 1, 1)); // b

        len = fis.read(bytes);
        System.out.println(len); // 1
        System.out.println(new String(bytes)); // cb

        len = fis.read(bytes);
        System.out.println(len); // -1
        System.out.println(new String(bytes)); // cb*/

        // 一次读取多个字节
        byte[] bytes = new byte[1024*1024];
//        int len = fis.read(bytes);
//        System.out.print(new String(bytes,0,len));
        // 或者 用循环
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
//            System.out.println(new String(bytes)); // 有空格 因定义的字节数组长度过长
            System.out.println(new String(bytes,0,len)); // 去除空格
        }

        // 释放资源
        fis.close();
    }

}
