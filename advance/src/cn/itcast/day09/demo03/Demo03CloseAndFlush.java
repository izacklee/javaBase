package cn.itcast.day09.demo03;

import java.io.FileWriter;
import java.io.IOException;

/*
    flush方法和close方法的区别
        flush：刷新缓冲区，流对象可以继续使用
        close：先刷新缓冲区，然后通知系统释放资源。留对象不可再被使用
*/
public class Demo03CloseAndFlush {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("advance/src/cn/itcast/day09/test/d.txt");
        fw.write(65); // A

        // 刷新之后流可以继续使用
        fw.flush();
        fw.write(67); // C

        // close之后流不可再被使用
        fw.close();

//        fw.flush(); // 错误写法！ java.io.IOException: Stream closed 流已经关闭
    }

}
