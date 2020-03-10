package com.zeroten.javales.day11y_thread;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo01Thread {

    public static void main(String[] args) throws Exception {
        // 集合线程安全类
        List<String> l = Collections.synchronizedList(
                Arrays.asList(new String[]{"迪丽热巴", "王丽坤"})
        );
        // 流的线程安全类
        InputStream in = new FileInputStream(
                                new File("src/test/java/com/zeroten/javales/day03y_io/a.txt")
                            );
        byte[] bs = new byte[in.available()];
        in.read(bs);
        ByteArrayInputStream bais = new ByteArrayInputStream(bs);
//        System.out.println(new String(bs));
        // 字符串的线程安全类
        StringBuffer sbf;

    }
}
