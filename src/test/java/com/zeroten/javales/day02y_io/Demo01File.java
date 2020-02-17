package com.zeroten.javales.day02y_io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo01File {

    public static void main(String[] args) throws Exception {
        // 文件在代码中的表现形式
        // 在创建File对象的时候，这个就是一个对象，没有读取文件，也不会验证
//        File f1 = new File("文件的路径（全路径）");
//        File f2 = new File("文件的路径","文件名");
//        dir1();
//        dir2();
//        dir3();
        dir4();
    }

    // 创建目录
    public static void dir1() {
        // 创建文件对象
        File f = new File("src/test/java/com/zeroten/javales/day02y_io/test/1/2/3");
        // 没有哪个规定，文件一定要有后缀
        System.out.println("文件或者目录是否存在：" + f.exists()); // false

        if(!f.exists()) {
//            boolean b = f.mkdir(); // 创建目录，不会创建不存在的父目录
            boolean b = f.mkdirs(); // 创建目录，同时创建父目录
            System.out.println(b); // true
        }

    }

    // 创建文件
    public static void dir2() throws IOException {
        File f = new File("src/test/java/com/zeroten/javales/day02y_io/test",
                "b"); // 文件后缀可有可无
        if(!f.exists()) {
            boolean b = f.createNewFile();
            System.out.println(b); // true
        }
    }

    // 判断是否是目录/文件
    public static void dir3() {
        File f = new File("src/test/java/com/zeroten/javales/day02y_io/test");
        File f2 = new File("src/test/java/com/zeroten/javales/day02y_io/test2","a2.txt");

        System.out.println(f.isDirectory()); // true
        System.out.println(f.isFile()); // false
        System.out.println(f2.isDirectory()); // false
        System.out.println(f2.isFile()); // false 目录或文件不存在,或者目录和文件都不存在，都返回false
    }

    // 相对路径/绝对路径
    public static void dir4() {
        File f = new File("src/test/java/com/zeroten/javales/day02y_io/test");
        File f2 = new File("src/test/java/com/zeroten/javales/day02y_io/test","a.txt");
        // 获取相对路径
//        System.out.println(f.getPath()); // src/test/java/com/zeroten/javales/day02y_io/test

        // 获取绝对路径
        // /Users/app/Downloads/javaproject/javatest/basic-code/slsweb/src/com/jinxun/githubmaven/
        // java_demo/src/test/java/com/zeroten/javales/day02y_io/test
//        System.out.println(f.getAbsolutePath());
        // 通常是需要找到在容器中的位置，在web当中有专门的方法

        // 获取字节长度 现在不用了
        System.out.println(f2.length()); // 6

        // 获取子目录列表，包括文件
        String[] list = f.list();
        // 获取带有相对路径的子目录列表，包括文件
        File[] listFiles = f.listFiles();
        System.out.println(Arrays.toString(list)); // [1, a.txt, b]
        // [src/test/java/com/zeroten/javales/day02y_io/test/1,
        // src/test/java/com/zeroten/javales/day02y_io/test/a.txt,
        // src/test/java/com/zeroten/javales/day02y_io/test/b]
        System.out.println(Arrays.toString(listFiles));

    }
}
