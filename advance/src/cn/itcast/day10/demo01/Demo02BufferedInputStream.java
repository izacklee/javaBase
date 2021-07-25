package cn.itcast.day10.demo01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
    java.io.BufferedInputStream extends InputStream
    BufferedInputStream：字节缓冲输入流

    继承自父类的成员方法：
        public abstract int read() : 从输入流读取数据的下一个字节。
        public int read(byte[] b) : 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。
        public void close() :关闭此输入流并释放与此流相关联的任何系统资源。

    构造方法：
        BufferedInputStream(InputStream in)：创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
        BufferedInputStream(InputStream in, int size) ：创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，
            即输入流 in，以便将来使用。
            参数：
                InputStream in：字节输入流
                    我们可以传递FileInputStream，缓冲流会给FileInputStream增加一个缓冲区，提高FileInputStream的读取效率
                int size：指定缓冲流内部缓冲区的大小，不指定默认

    使用步骤（重点）：
        1.创建FileInputStream对象，构造方法中传递读取数据源
        2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream的读取效率
        3.使用BufferedInputStream对象的read方法，读取文件
        4.释放资源
*/
public class Demo02BufferedInputStream {

    public static void main(String[] args) throws IOException {
        // 1.创建FileInputStream对象
        FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day10/test/buffered.txt");
        // 2.创建BufferedInputStream对象
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 3.读取文件
        /*int len = 0; // 记录每次读取到的字节
        while ((len = bis.read()) != -1) {
            System.out.println((char)len);
        }*/
        // 一次读取多个字节
        byte[] bytes = new byte[1024]; // 存储每次读取的数据
        int len = 0; // 记录每次读取到的字节数
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len)); // a 读取字节缓冲输入流数据！
        }

        // 4.释放资源
        bis.close();
    }

}
