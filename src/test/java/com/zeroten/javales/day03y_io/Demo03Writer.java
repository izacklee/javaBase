package com.zeroten.javales.day03y_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

// 字符输出流
public class Demo03Writer {

    public static void main(String[] args) throws Exception{
        Writer w = new OutputStreamWriter(
                new FileOutputStream(
                        // c.txt 文件不存在会自动创建
                        new File("src/test/java/com/zeroten/javales/day03y_io","c.txt")
                )
        );
        w.write("I/O流中的字符输出流");
        w.flush();
        w.close();
    }
}
