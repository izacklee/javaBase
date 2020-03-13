package com.zeroten.javales.day06y_xml.homework.main;

import com.zeroten.javales.day06y_xml.homework.server.FileServer;

/*
* 文件名称：main.Test
* 初始作者：ZackLee</br>
* 创建时间：2020/03/05 10:20</br>
* 功能说明：【】</br>
* ======================================</br>
* 修改记录：</br>
* 修改作者 日期 修改内容</br>
* ======================================</br>
* Copyright（c）2020-2021 .All rights reserved.</br>
* */
public class Test {
    private static FileServer fileServer = FileServer.fileServerFunction();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String pathName = "src/test/java/com/zeroten/javales/day06y_xml/homework";
        boolean b = fileServer.readFileWrite(pathName, null, null);
        // 读xml文件
        if (b) {
            System.out.println("xml文件写入成功，下面是读取的内容。。。");
            System.out.println("");
            fileServer.readXML();
        } else {
            System.out.println("xml文件写入失败。。。");
        }
    }
}
