package cn.itcast.day10.demo04;

import java.io.FileReader;
import java.io.IOException;

/*
    FileReader：可以读取IDE默认的编码格式（UTF-8）的文件
    FileReader：读取系统默认编码（中文GBK）会产生乱码���
*/
public class Demo01FileReader {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("advance/src/cn/itcast/day10/test/我是GBK格式的文件.txt");
        char[] c = new char[1024];
        int len = 0;
        while ((len = fr.read(c)) != -1) {
            System.out.print(new String(c,0, len)); // ���
        }
        fr.close();
    }

}
