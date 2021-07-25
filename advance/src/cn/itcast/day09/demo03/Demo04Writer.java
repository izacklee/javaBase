package cn.itcast.day09.demo03;

import java.io.FileWriter;
import java.io.IOException;

/*
    字符输出写入数据的其他方法：
        void write(char[] cbuf)：写入字符数组。
        abstract void write(char[] cbuf, int off, int len)：写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        void write(String str)：写入字符串。
        void write(String str, int off, int len)：写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
*/
public class Demo04Writer {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("advance/src/cn/itcast/day09/test/e.txt");
        // void write(char[] cbuf)：写入字符数组。
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        fw.write(c); // abcde

        // abstract void write(char[] cbuf, int off, int len)
        fw.write(c,1,2); // bc

        // void write(String str)
        fw.write("Hello");

        // void write(String str, int off, int len)
        fw.write("Hello World",6,5);

        fw.close();

    }

}
