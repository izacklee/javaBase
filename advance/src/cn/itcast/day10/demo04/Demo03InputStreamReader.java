package cn.itcast.day10.demo04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    java.io.InputStreamReader extends Reader
    InputStreamReader：是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。（解码：把看不懂的变成能看懂的）

    成员方法：
        public int read() : 读取单个字符并返回。
        public int read(char[] cbuf) : 一次读取多个字符，将字符读入数组。
        public void close() :关闭此流并释放与此流相关联的任何系统资源。

    构造方法：
        InputStreamReader(InputStream in)：创建一个使用默认字符集的 InputStreamReader。
        InputStreamReader(InputStream in, String charsetName) ：创建使用指定字符集的 InputStreamReader。
            参数：
                InputStream out：字节输入流，可以用来读文件中保存的字节
                String charsetName：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8,gbk/GBK,...不指定默认UTF-8（IDE默认）

    使用步骤：
        1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
        2.使用InputStreamReader对象中的read方法，读取文件
        3.释放资源

    注意事项：
        构造方法中指定的编码表名称要和文件编码相同，否则会出现乱码。
*/
public class Demo03InputStreamReader {

    public static void main(String[] args) throws IOException {
//        readUFT8();
        readGBK();
    }

    // 使用转换流InputStreamReader读取GBK文件
    private static void readGBK() throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("advance/src/cn/itcast/day10/test/gbk.txt"), "GBK");

        // 一次读取一个字节方式
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.print((char)len); // 你好
        }

        // 使用字符数组缓冲多个字节，读取多个字节的方式
        /*char[] c = new char[1024];
        int len = 0;
        while ((len = isr.read(c)) != -1) {
            System.out.print(new String(c, 0, len)); // 你好
        }*/

        isr.close();
        isr.close();
    }

    // 使用转换流InputStreamReader读取UTF-8文件
    private static void readUFT8() throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("advance/src/cn/itcast/day10/test/utf8.txt"), "UTF-8");
        char[] c = new char[1024];
        int len = 0;
        while ((len = isr.read(c)) != -1) {
            System.out.print(new String(c, 0, len)); // 你好
        }
        isr.close();
    }

}
