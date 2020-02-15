package com.zeroten.javales.day03y_io;

import java.io.*;
import java.util.LinkedList;

public class ReaderDemo {

    public static void main(String[] args) throws Exception {
//        String rootPath = System.getProperty("user.dir"); // 获取工程目录的当前路径
        /*
            对于 UNIX 平台，绝对路径名的前缀始终是 "/"。相对路径名没有前缀。
                           表示根目录的绝对路径名的前缀为 "/" 且名称序列为空。
            对于 Microsoft Windows 平台，包含盘符的路径名前缀由驱动器号和一个 ":" 组成。
                          如果路径名是绝对路径名，还可能后跟 "\\"。UNC 路径名的前缀是 "\\\\"；
                          主机名和共享名是名称序列中的前两个名称。没有指定驱动器的相对路径名没有前缀。
         */
        Reader r = new InputStreamReader(
                new FileInputStream(
                        /*
                           java.io.*包下，默认定位到用户("user.dir")目录下，即工程目录/Users/app/Downloads/
                              javaproject/javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo
                           注：相对路径没有前缀"/"
                         */
                        new File( "src/test/java/com/zeroten/javales/day03y_io/a.txt")));
        // char == int
//        LinkedList<Character> linked = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        while(r.read() != -1) {
            sb.append(r);
        }
        System.out.println(sb.toString());
        r.close();
    }
}
