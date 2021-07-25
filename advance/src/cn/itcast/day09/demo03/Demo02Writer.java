package cn.itcast.day09.demo03;

import java.io.FileWriter;
import java.io.IOException;

/*
    java.io.Writer：字符输出流，是所有字符输出流的最顶层超类，是一个抽象类

    共性成员方法：
        void write(int c)：写入单个字符。
        void write(char[] cbuf)：写入字符数组。
        abstract void write(char[] cbuf, int off, int len)：写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        void write(String str)：写入字符串。
        void write(String str, int off, int len)：写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        void flush()：刷新该流的缓冲。
        void close()：关闭此流，但要先刷新它。

    java.io.FileWriter extends OutputStreamWriter extends Writer
    FileWriter：文件字符输出流
        作用：把内存中的字符数据写入到文件中

    构造方法：
        FileWriter(File file) ：根据给定的 File 对象构造一个 FileWriter 对象。
        FileWriter(String fileName)：根据给定的文件名构造一个 FileWriter 对象。
            参数：
                File file：是一个文件
                String FileName：文件路径
        构造方法的作用：
            1.会一个FileWriter对象
            2.会根据构造方法中的文件/文件路径，创建文件
            3.会把FileWriter对象指向创建好的文件

    字符流的使用步骤（重点）：
        1.创建FileWriter对象，构造方法中传递要写入的数据源
        2.使用FileWriter中的write方法，把数据写入到内存缓冲区中（字符转为字节的过程）
        3.使用FileWriter中的flush，把内存缓冲区的数据，刷新到文件中
        4.释放资源（会先把内存中缓存的数据先刷新到文件中）
*/
public class Demo02Writer {

    public static void main(String[] args) throws IOException {
        // 1.创建FileWriter对象
        FileWriter fw = new FileWriter("advance/src/cn/itcast/day09/test/d.txt");
        // 2.写入数据
        fw.write(97);
        fw.write(98);
//        // 3.刷新数据  也可不写 调用close方法时会先刷新数据 但是要注意调用close方法之后，不能再调用write写入数据了
//        fw.flush();

        // 4.释放资源
        fw.close();
    }

}
