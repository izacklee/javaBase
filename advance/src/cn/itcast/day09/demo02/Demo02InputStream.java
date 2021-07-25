package cn.itcast.day09.demo02;

import java.io.FileInputStream;
import java.io.IOException;

/*
    使用字节流读取中文文件

    1个中文：
        GBK： 占用2个字节
        UTF-8：占用3个字节
*/
public class Demo02InputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("advance/src/cn/itcast/day09/test/a.txt");

        int len = 0;
        while ((len = fis.read()) != -1) {
            // 每次只读取一个字节 但是这里默认为UTF-8编码，一个中文占用3个字节，所以出现了乱码的情况
            System.out.print((char)len); // abcefghdä½ å¥½åï¼ 出现乱码了
        }
        fis.close();
    }

}
