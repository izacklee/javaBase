package com.zeroten.javales.day02y_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// 输入流2
public class Demo03FileInputStream {

    public static void main(String[] args) throws Exception {
        File f = new File("src/test/java/com/zeroten/javales/day02y_io/test","c.txt");
        InputStream input = new FileInputStream(f);
        int len = input.available();
        byte[] bs = new byte[len];
        byte temp = -1;
        int index = 0;
        //        input.read(); // 一次读一个字节，调用一次，自动读下一个字节
        while((temp = (byte) input.read()) != -1) {
            bs[index] = temp;
            index++;
        }
        String str = new String(bs);
        System.out.println(str);
        input.close();
    }
}
