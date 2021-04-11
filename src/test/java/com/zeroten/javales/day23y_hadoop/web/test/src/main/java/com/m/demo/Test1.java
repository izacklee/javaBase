package com.m.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

public class Test1 {

    public static void main(String[] args) {
        // 注意：启动./start-dfs.sh后 大概过30秒访问才生效 有延时 刚启动直接访问会报错

        // 1 windows强制加载hadoop.dll mac不需要
//        System.loadLibrary("/usr/local/hadoop/bin/hadoop"); // 不包含扩展名
//        System.load("/usr/local/hadoop/bin/hadoop");

        // 2 指定用户，指定hadoop的根目录
        System.setProperty("HADOOP_USER_NAME", "root");
        System.setProperty("hadoop.home.dir", "/usr/local/hadoop");

        // 3 创建与hdfs的连接
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://www.hadoopceshi.com:9000");

        // 4 获取文件系统，hdfs的操作，和我们再java中操作file大同小异
        FileSystem fs = null;
        FSDataOutputStream out = null;
        FSDataInputStream in = null;
        try {
            fs =  FileSystem.get(conf); // 获取文件系统
            // 判断是否是文件
//            System.out.println(fs.isFile(new Path("/input"))); // false
//            System.out.println(new Thread().getContextClassLoader().getResource("resources/log4j.properties"));
            // 判断是否是目录
//            System.out.println(fs.isDirectory(new Path("/input"))); // true

            // 查看子文件或者子目录
//            FileStatus[] list = fs.listStatus(new Path("/"));
//            for (FileStatus status : list) {
//                System.out.println(status.getGroup()); // 当前用户组
//                System.out.println(status.getOwner()); // 当前用户
//                System.out.println(status.getPath()); // 当前路径
//            }

            // 流操作
            // 写入-输出流
//            out =  fs.append(new Path("/input/test"));
//            out.write("这是hdfs流操作写入!".getBytes());
//            out.close();
//            System.out.println("success");
            
            // 读取-输入流
            in = fs.open(new Path("/input/test"));
            byte[] bs = new byte[in.available()];
            in.read(bs);
            System.out.println(new String(bs));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

}
