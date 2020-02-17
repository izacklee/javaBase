package com.zeroten.javales.day02y_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

// 输出流2
public class Demo05FileOutputStream {

    public static void main(String[] args) throws Exception {
        OutputStream out = new FileOutputStream(
                new File("src/test/java/com/zeroten/javales/day02y_io/test","c.txt"));
        String str = "本章节学习I/O流的使用\n这是输出流2的操作";
        byte[] bs = str.getBytes();
        for(byte b : bs) {
            out.write(b);
        }
        out.flush();
        out.close();
    }
}
