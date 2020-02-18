package com.zeroten.javales.day03y_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 缓冲字符流
public class Demo02Reader {

    public static void main(String[] args) throws Exception {
        // 缓冲：默认大小8192/8k
        BufferedReader br = new BufferedReader(
                        new InputStreamReader( // 设字符集
                                new FileInputStream(
                                        new File("src/test/java/com/zeroten/javales/day03y_io","a.txt")
                                )
                        ));
        // 字符流开始，缓冲才有意义
        StringBuffer sb = new StringBuffer();
        String s = "";
        // readLine() 每次读一行
        while((s = br.readLine()) != null) {
            sb.append(s);
            sb.append("\n"); // 读的时候，换行符无法读取，所以需要单独加
        }
        System.out.println(sb);
        br.close();
    }
}
