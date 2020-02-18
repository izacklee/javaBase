package com.zeroten.javales.day03y_io;

import java.io.*;

public class Demo05DataStream {

    public static void main(String[] args) throws Exception {
        // 这是个文件，用于保存“内存数据”
        // 把这个文件当成一个持久化的对象
        File f = new File("src/test/java/com/zeroten/javales/day03y_io","person.o");

        if(!f.exists()) {
            f.createNewFile();
        }
        /*
            数据输出流：写数据
        DataOutputStream out = new DataOutputStream(
                                new FileOutputStream(f)
                            );
        out.writeInt(1);
        out.writeUTF("ZackLee");
        out.writeInt(18);
        out.flush();
        out.close();
         */

        // 数据输入流：读数据
        DataInputStream input = new DataInputStream(
                                new FileInputStream(f)
                            );
        // 注意：读写顺序不能乱，要对应
        int i = input.readInt();
        String s = input.readUTF();
        int i2 = input.readInt();
        System.out.println(i);
        System.out.println(s);
        System.out.println(i2);

        input.close();
    }
}
