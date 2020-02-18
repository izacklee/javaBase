package com.zeroten.javales.day03y_io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

// 字符流
public class Demo01Reader {

    public static void main(String[] args) throws Exception {
        // InputStreamReader(InputStream in); // 参数
        // InputStreamReader(InputStream in, String charsetName); // 设字符集
        // 一般常用字符集：GBK/UTF-8/GB2312/IOS-8859-1--->保证统一
        // 字符串可以指定编码集的编码和解码
//        String s1 = new String(bytes, "newcharset");
//        String s2 = new String("charset");

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
        // 使用泛型，强制统一数据类型
        // 泛型的基本数据类型，只能使用包装类（因基本数据类型不是对象，泛型必须是对象）
//        LinkedList<Character> linked = new LinkedList<>(); // 增删快
        // 单一线程下，StringBuilder和StringBuffer的效果是一样的
//        StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        int temp = -1;
        while( (temp = r.read()) != -1) { // 注：char没有-1
            sb.append((char) temp);
        }
        System.out.println(sb);
        r.close();
    }
}
