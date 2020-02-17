package com.zeroten.javales.day02y_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

// 输入流1
public class Demo02FileInputStream {
    // 程序：以程序作为参照物
    public static void main(String[] args) throws Exception {
        // 使用流操作文件
        File f = new File("src/test/java/com/zeroten/javales/day02y_io/test","a.txt");
        long len1 = f.length();
        // 注意！！！！
        // 这只是一个dome~!
        // 目的：明白字节流的使用方法。
        InputStream input = new FileInputStream(f);
        int len2 = input.available(); // 获取可读数据的大小（单位字节）
        // 数组的创建，必然要指定长度，java中默认int
        byte[] bs = new byte[len2];
        input.read(bs); // 输入流直接写入内存地址（太粗暴了，一次性，把所有数据都读进来）
        String str = new String(bs);
        System.out.println(str); // 123456
        input.close(); // 关闭流
    }
}
