package com.zeroten.javales.day02y_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

// 输出流1
public class Demo04FileOutputStream {

    // 程序：以程序作为参照物
    public static void main(String[] args) throws Exception{
        // 创建输出流
        OutputStream out = new FileOutputStream(
                new File("src/test/java/com/zeroten/javales/day02y_io/test","c.txt"));
        // 输出流，是覆盖原文件里的内容，不是追加
        String str = "本章节学习I/O流的使用\n这是输出流的操作";
        // 获取写入字符串的字节
        byte[] bs = str.getBytes();
        // 写入数据
        out.write(bs); // 很粗暴
        out.flush(); // 把缓冲器的数据推送到输出流里（是否使用，看数据量，大用小可不用）
        // 关闭流
        out.close();
    }

}
