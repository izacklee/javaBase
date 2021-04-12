package com.m.service.impl;

import com.m.service.HDFSService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class HDFSServiceImpl implements HDFSService {

//    static {
//        // 强制加载 （为了防止windows解析不了，保证不会出错，其他系统可不加）
//        System.load("/usr/local/hadoop/bin/hadoop");
//        // 指定用户，指定hadoop的根目录
//        System.setProperty("HADOOP_USER_NAME", "root");
//        System.setProperty("hadoop.home.dir", "/usr/local/hadoop");
//    }
//
    private final String BASE_PATH = "/filecloud";
    public HDFSServiceImpl() {

    }
    
    private Configuration getConfiguration() {
        // 创建与hdfs的连接
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://www.hadoopceshi.com:9000");
        return conf;
    }
    
    @Override
    public boolean mkdir(String path) {
        // hdfs操作，和java中的file操作大同小异
        FileSystem fs = null;
        FSDataOutputStream out = null;
        FSDataInputStream in = null;
        try {
            fs = FileSystem.get(this.getConfiguration());
            Path p = new Path(this.BASE_PATH + "/" + path);
            return fs.mkdirs(p);
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
        }

        return false;
    }
}
