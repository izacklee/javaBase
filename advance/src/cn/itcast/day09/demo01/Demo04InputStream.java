package cn.itcast.day09.demo01;

import java.io.FileInputStream;
import java.io.IOException;

/*
    java.io.InputStream：字节输入流
    此抽象类是表示字节输入流的所有类的超类。

    定义了所有子类共性的方法：
        public abstract int read() : 从输入流读取数据的下一个字节。
        public int read(byte[] b) : 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。
        public void close() :关闭此输入流并释放与此流相关联的任何系统资源。

    java.io.FileInputStream extends InputStream
    FileInputStream：文件字节输入流
        作用：把硬盘文件中的数据，读取到内存中使用

    构造方法：
        FileInputStream(String name)：通过打开一个到实际文件的连接来创建一个 FileInputStream，
            该文件通过文件系统中的路径名 name 指定。
        FileInputStream(File file)：通过打开一个到实际文件的连接来创建一个 FileInputStream，
            该文件通过文件系统中的 File 对象 file 指定。
        参数：读取文件的数据源
            String name：文件的路径
            File file：文件
        构造方法的作用：
            1.创建一个FileInputStream对象
            2.会把FileInputStream对象指定构造方法中要读取的文件

    读取数据的原理（硬盘-->内存）：
        Java程序-->JVM-->OS（操作系统 Operating System）-->调用读取数据的方法-->读取文件

    字节输入流的使用步骤：
        1.创建FileInputStream对象，构造方法中传递要读取的数据源
        2.使用FileInputStream对象中的read方法，读取文件
        3.释放资源
*/
public class Demo04InputStream {

    public static void main(String[] args) throws IOException {
        // 1.创建FileInputStream对象
        FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day09/test/a.txt");
        // 2.读取文件 读取单个字节
//        int len = fis.read();
//        System.out.println(len); // 97 a

        // 读取多个字节 不知道循环次数 用while循环
        // 注：读取完单个字节后，指针会向后移动一位；读取到文件末尾没数据时，返回-1
        /*
            布尔表达式：(l = fis.read()) != -1
                1.fis.read()：读取一个字节
                2.l = fis.read()：把读取到的字节赋值给变量l
                3.(l = fis.read()) != -1 ：判断变量l是否等于-1
        */
        int l = 0; // 记录读取到的字节（不会被覆盖）
        while ((l = fis.read()) != -1) {
//            System.out.print(l); // 979899
            System.out.print((char)l); // abc
        }


        // 3.释放资源
        fis.close();
    }

}
