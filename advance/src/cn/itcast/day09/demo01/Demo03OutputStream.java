package cn.itcast.day09.demo01;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    追加写/续写：使用两个参数的构造方法
        public FileOutputStream(File file, boolean append) : 创建文件输出流以写入由指定的 File对象表示的 文件。
        public FileOutputStream(String name, boolean append) : 创建文件输出流以指定的名称写入文件。
            参数：
                String name, File file：写入数据的目的地
                boolean append：追加写开关
                    true：创建对象不会覆盖源文件，继续在文件末尾追加写数据
                    false：创建一个新文件，覆盖源文件
             写换行：写换行的符号
                windows：\r\n
                linux：/n
                mac：\r

*/
public class Demo03OutputStream {

    public static void main(String[] args) throws IOException {
        // 1.创建FileOutputStream对象
        FileOutputStream fos = new FileOutputStream("advance/src/cn/itcast/day09/test/c.txt", true);
        // 2.写入文件
        byte[] bytes = "你好".getBytes();
        // 循环写入10次
        for (int i = 0; i < 10; i++) {
            fos.write(bytes);
            fos.write("\r".getBytes()); // 换行
        }


        // 3.释放资源
        fos.close();
    }

}
