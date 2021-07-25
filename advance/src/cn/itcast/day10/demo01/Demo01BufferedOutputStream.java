package cn.itcast.day10.demo01;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    java.io.BufferedOutputStream extends OutputStream
    BufferedOutputStream：字节缓冲输出流

    继承父类的共性方法：
        public void close() :关闭此输出流并释放与此流相关联的任何系统资源。
        public void flush() :刷新此输出流并强制任何缓冲的输出字节被写出。
        public void write(byte[] b) :将 b.length字节从指定的字节数组写入此输出流。
        public void write(byte[] b, int off, int len) :从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
        public abstract void write(int b) :将指定的字节输出流。

    构造方法：
        BufferedOutputStream(OutputStream out) ：创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
        BufferedOutputStream(OutputStream out, int size) ：创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
            参数：
                OutputStream：字节输出流
                    可以传递FileOutputStream，缓冲流会给FileOutputStream增加一个缓冲区，提高FileOutputStream的写入效率
                int size：指定缓冲流内部缓冲区的大小，不指定默认
    使用步骤（重点）：
        1.创建FileOutputStream对象，构造方法中传递要输出的目的地
        2.创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高写入效率
        3.使用BufferedOutputStream对象中的write方法，把数据写到内存缓冲区
        4.使用BufferedOutputStream对象中的flush方法，把缓冲区的数据刷新到文件中
        5.释放资源（释放前先调用flush方法刷新数据，第4部可省略）
*/
public class Demo01BufferedOutputStream {

    public static void main(String[] args) throws IOException {
        //路径文件夹不存在，先创建
        File f = new File("advance/src/cn/itcast/day10/test");
        f.mkdirs();

        // 1.创建FileOutputStream对象
        FileOutputStream fos = new FileOutputStream("advance/src/cn/itcast/day10/test/buffered.txt");
        // 2.创建BufferedOutputStream对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 3.把数据写入到内存缓冲区
        bos.write(97);
        // 4.把缓冲区的数据刷新到文件中
        bos.flush();

        // 5.释放资源 只需要关闭BufferedOutputStream字节缓冲输出流即可，因为FileOutputStream只在BufferedOutputStream里有效，
        // BufferedOutputStream字节缓冲输出流关闭了，FileOutputStream字节输出流就自动关闭了。
        bos.close();


    }

}
