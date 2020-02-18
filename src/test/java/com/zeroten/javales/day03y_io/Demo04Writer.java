package com.zeroten.javales.day03y_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

// 字符输出流2
public class Demo04Writer {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(
                                        new File("src/test/java/com/zeroten/javales/day03y_io","c.txt")
                                )
                        )
                    );
        bw.write("I/O字符输出流\n缓冲字符输出流");
        bw.flush();
        bw.close();

    }
}
