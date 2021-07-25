package cn.itcast.day09.demo01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
     一次写多个字节的方法：
        public void write(byte[] b) :将 b.length字节从指定的字节数组写入此输出流。
            如果写的第一个字节是正数（0~127），那么显示的时候会查询ASCII表
            如果写的第一个字节是负数，那么第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认码表（GBK）
            GBK：2个字节一个中文
            UTF-8：3个字节一个中文
        public void write(byte[] b, int off, int len) :从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
            int off：数组的开始索引
            int len：写几个字节

     写入字符的方法：可以用String类中的方法把字符串，转换为字节数组
        byte[]	getBytes()：使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
*/
public class Demo02OutputStream {

    public static void main(String[] args) throws IOException {
        // 1.创建FileOutputStream对象，构造方法中传递要写入的数据目的地
        FileOutputStream fos = new FileOutputStream("advance/src/cn/itcast/day09/test/b.txt");

        // 2.写入文件 要求在文件中显示100
        fos.write(49);
        fos.write(48);
        fos.write(48);

        // 一次写多个字节的方法
        // public void write(byte[] b) :将 b.length字节从指定的字节数组写入此输出流。
        byte[] bytes = {65, 66, 67, 68, 69}; // ABCDE
//        byte[] bytes = {-65, -66, -67, 68, 69}; // 烤紻E
//        fos.write(bytes);
        // public void write(byte[] b, int off, int len) :从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
        fos.write(bytes,1,2); // BC

        // 用String类中的方法把字符串，转换为字节数组
        byte[] bytes1 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes1)); // [-28, -67, -96, -27, -91, -67]
        fos.write(bytes1); // 你好


        // 3.释放资源
        fos.close();

    }

}
