package com.zeroten.javales.day06y_xml.homework.server;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/*
* 文件名称：server.FileServer
* 初始作者：ZackLee</br>
* 创建日期：2020/03/05 10:40</br>
* 功能说明：【】</br>
* =========================================</br>
* 修改记录：</br>
* 修改作者 日期 修改内容</br>
* =========================================</br>
* Copyright（c）2020-2021 .All rights reserved.</br>
* */
public class FileServer {

    private static FileServer fileServer;

    public static FileServer fileServerFunction() {
        if (fileServer == null) {
            synchronized(FileServer.class) {
                fileServer = new FileServer();
            }
        }
        return fileServer;
    }

    /*
     * 方法描述：[查询文件列表]</br>
     * 初始作者：ZackLee</br>
     * 创建时间：2020/03/05 11:50</br>
     * 创建版本：1.0.0</br>
     * =====================================</br>
     * 修改记录：</br>
     * 修改作者 日期 修改内容</br>
     * ======================================</br>
     *
     * @param pathName
     * @return java.util.List<java.io.File>
     *
     */
    public List<File> showFiles(String pathName) {
        File f = new File(pathName);
        return Arrays.asList(f.listFiles());
    }

    /*
    * 方法描述：[判断是文件还是目录]
    * 初始作者：ZackLee</br>
    * 创建日期：2020/03/05 14:02</br>
    * 开始版本：1.0.0</br>
    * =========================================</br>
    * 修改记录：</br>
    * 修改作者 日期 修改内容</br>
    * ==========================================</br>
    *
    * @param pathName
    * @return java.lang.Boolean
    */
    public Boolean fileOrMrk(String pathName) {
        File f = new File(pathName);

        // 路径不存在
        if (f.exists()) {
            throw new RuntimeException("File not found");
        }

        // 文件夹
        if (f.isDirectory()) {
            return true;
        }

        // 文件
        if (f.isFile()) {
            return false;
        }

        return false;
    }
}
