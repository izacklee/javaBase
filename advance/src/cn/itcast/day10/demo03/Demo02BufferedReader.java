package cn.itcast.day10.demo03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    java.io.BufferedReader extends Reader
    BufferedReader：字符缓冲输入流

    继承自父类的共性成员方法：
        public int read() : 读取单个字符并返回。
        public int read(char[] cbuf) : 一次读取多个字符，将字符读入数组。
        public void close() :关闭此流并释放与此流相关联的任何系统资源。

    构造方法：
        BufferedReader(Reader in)：创建一个使用默认大小输入缓冲区字符输入流
        BufferedReader(Reader in, int sz)：创建一个使用指定大小输入缓冲区的缓冲字符输入流。
            参数：
                Reader in：字符输入流
                    我们可以传递FileReader，缓冲流会给FileReader增加一个缓冲区，提高读取效率。
                int sz： 指定缓冲区的大小，不写用默认大小

     特有的成员方法：
        String readLine()：读取一个文本行。读取一行数据
            行的终止符号：通过下列字符之一即可认为某行已经终止：换行（'\n'）、回车（'\r'）或回车后直接跟着换行('\r\n').
            返回值：
                包含该行内容的字符串，不包含任何终止符，如果已到达流末尾，则返回null。

     使用步骤：
        1.创建字符缓冲输入流对象，构造方法中传递字符输入流
        2.使用字符缓冲输入流对象中的方法read/readLine读取文本
        3.释放资源
*/
public class Demo02BufferedReader {

    public static void main(String[] args) throws IOException {
        // 1.创建字符缓冲输入流对象，构造方法中传递字符输入流
        BufferedReader br = new BufferedReader(new FileReader("advance/src/cn/itcast/day10/test/a.txt"));
        // 2.使用字符缓冲输入流对象中的方法read/readLine读取文本
        char[] c = new char[1024];
        int len = 0;
        /*while ((len = br.read(c)) != -1) {
            System.out.println(new String(c, 0 , len));
        }*/
        // 使用readLine每次读取一行字符，结束标记为null
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        // 3.释放资源
        br.close();
    }

}
