package cn.itcast.day09.demo02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    文件复制练习：一读一写

    明确：
        数据源：advance/src/cn/itcast/day09/test/a.txt
        数据的目的地：advance/src/cn/itcast/day08/test/a.txt

    文件复制的步骤：
        1.创建一个字节输入流对象，构造方法中传递要读取的数据
        2.创建一个字节输出流对象，构造方法中传递要写入的目的地
        3.使用字节输入流对象的read方法，读取文件
        4.使用字节输出流对象的write，把读取到的文件写入指定的目的地
        5.释放资源
*/
public class Demo01CopyFile {

    public static void main(String[] args) throws IOException {
        // 程序运行开始时间 毫秒值
        long s = System.currentTimeMillis();

        // 1.创建字节流输入对象
        FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day09/test/a.txt");
        // 2.创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("advance/src/cn/itcast/day08/test/a.txt");

        // 3.读取文件
        /*int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.print(len + ","); // 97,98,99,101,102,103,104,100,  返回字节数
            // 4.写入文件
            fos.write(len);
        }*/

        // 使用数据缓冲读取多个字节，写入多个字节
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }

        // 5.释放资源（先关闭写，后关闭读，因为写完了，肯定读完了）
        fos.close();
        fis.close();

        // 程序运行结束时间
        long e = System.currentTimeMillis();
        System.out.println("程序运行总耗时：" + (e-s) + "毫秒"); // 程序执行总耗时：6毫秒
    }

}
