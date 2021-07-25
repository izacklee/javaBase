package cn.itcast.day10.demo02;

import java.io.*;

/*
     文件复制练习：一读一写

     明确：
        数据源：advance/src/cn/itcast/day09/test/a.txt
        数据的目的地：advance/src/cn/itcast/day08/test/a.txt

     文件复制的步骤：
        1.创建字节缓冲输入流对象，构造方法中传递字节输入流
        2.创建字节缓冲输出流对象，构造方法中传递字节输出流
        3.使用字节缓冲输入流对象的read方法，读取文件
        4.使用字节缓冲输出流的write方法，把数据写入到内部缓冲区中
        5.释放资源（会先把缓冲区的数据，刷新到文件中）

     文件大小：799字节
     一次读取一个字节：3毫秒
     使用缓冲读取多个字节，写入多个字节：1毫秒（使用缓冲流，比使用数组缓冲还要快）
*/
public class Demo01CopyFile {

    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();

        // 1.创建字节缓冲输入流对象，构造方法中传递字节输入流
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("advance/src/cn/itcast/day10/test/buffered.txt"));
        // 2.创建字节缓冲输出流对象，构造方法中传递字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("advance/src/cn/itcast/day10/test/bufferedCopy.txt"));
        // 3.使用字节缓冲输入流对象的read方法，读取文件
        // 一次读取一个字节，写入一个字节
        /*int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }*/

        // 使用缓冲区读取多个字节，写入多个字节
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            // 4.使用字节缓冲输出流的write方法，把数据写入到内部缓冲区中
            bos.write(bytes, 0 , len);
        }
        // 5.释放资源（会先把缓冲区的数据，刷新到文件中）
        bos.close();

        long e = System.currentTimeMillis();
        System.out.println("总共耗时:" + (e - s) + "毫秒");
    }

}
