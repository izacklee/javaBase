package cn.itcast.day09.demo01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    java.io.OutputStream：字节输出流
        此抽象类是表示输出字节流的所有类的超类。

    定义了一些子类共性的成员方法：
        public void close() :关闭此输出流并释放与此流相关联的任何系统资源。
        public void flush() :刷新此输出流并强制任何缓冲的输出字节被写出。
        public void write(byte[] b) :将 b.length字节从指定的字节数组写入此输出流。
        public void write(byte[] b, int off, int len) :从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
        public abstract void write(int b) :将指定的字节输出流。

    java.io.FileOutputStream extends OutputStream
    FileOutputStream：文件字节输出流
        作用：把内存中的数据写入到硬盘文件中

    构造方法：
        FileOutputStream(String name) ：创建一个向具有指定名称的文件中写入数据的输出文件流。
        FileOutputStream(File file)：创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
            参数：写入数据的目的
                String name：目的地是一个文件的路径
                File file：目的地是一个文件
            构造方法的作用：
                1.创建一个FileOutputStream对象
                2.会根据构造方法中传递的文件/文件路径，创建一个空的文件
                3.会把FileOutputStream对象指向创建好的文件

    写入数据的原理（内存-->硬盘）：
        1.创建一个FileOutputStream对象，构造方法中写入数据的目的地
        2.调用FileOutputStream对象中的write，把数据写入到文件中
        3.释放资源（流使用会占用一定的内存，使用完毕要把内存清空，提升程序效率）
*/
public class Demo01OutputStream {

    public static void main(String[] args) throws IOException {
        //路径文件夹不存在，先创建
        File f = new File("advance/src/cn/itcast/day09/test");
        f.mkdirs();

        // 1.创建FileOutputStream对象，构造方法传入写入数据的目的地
        FileOutputStream fos = new FileOutputStream("advance/src/cn/itcast/day09/test/a.txt");

        // 2.写入文件 硬盘中存储的都是字节 1个字节=8个比特位（10101010）
        // 计算机中一切文件都是二进制的数字
        fos.write(97); // a  写入硬盘前先把十进制数据97，转换为二进制整数为1100001，之后再把这个数存到硬盘

        // 3.释放资源
        fos.close();

    }

}

