package com.m.service.impl;

import com.m.entity.FileItem;
import com.m.service.HDFSService;
import com.m.util.BaseUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

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

    /**
     * 创建文件夹
     * @param path
     * @return
     */
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

    /**
     * 文件列表
     * @param path
     * @return
     */
    @Override
    public List<FileItem> ListFile(String path) {
        
        List<FileItem> items = new ArrayList<>();
        FileSystem fs = null;

        try {

            fs = FileSystem.get(this.getConfiguration());
            FileStatus[] fss = fs.listStatus(new Path(this.BASE_PATH + "/" + path));

            for (FileStatus status : fss) {
                FileItem item = new FileItem();
                Integer isDir = status.isDirectory() ? 1 : 0;
                String fileName = status.getPath().getName();
                Integer fileType = BaseUtil.getFileType(fileName);
                item.setFilePath(path + ("/".equals(String.valueOf(
                        path.charAt(path.length()-1))) ? "" : "/") + fileName);
                item.setFileName(fileName);
                item.setFileType(fileType);
                item.setIsDir(isDir);
                items.add(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 根据文件类型排序 文件夹排前面
        Collections.sort(items, new Comparator<FileItem>() {
            @Override
            public int compare(FileItem o1, FileItem o2) {
                return o1.getFileType().compareTo(o2.getFileType());  // 升序
            }
        });

        return items;
    }

    // hdfs 的上传
    @Override
    public boolean upload(InputStream in, String path) {
        FileSystem fs = null;
        try {
            fs  = FileSystem.get(this.getConfiguration());
            OutputStream out = fs.create(new Path(this.BASE_PATH + "/" + path)); // 创建输出流
            /**
                IOUtils.copyBytes(in, out, 4096, false)
                –in:是FSDataInputStream类的对象，是有关读取文件的类，也就是所谓“输入流”
                –out:是FSDataOutputStream类的对象，是有关文件写入的类，也就是“输出流”
                –4096表示用来拷贝的buffer大小（buffer是缓冲区）–缓冲区大小
                –// true - 是否关闭数据流，如果是false，就在finally里关掉。IOUtils.closeStream(in);
                IOUtils.copyBytes(in, System.out, 4096, false) 输出到控制台
            */
            IOUtils.copyBytes(in, out, 4096, true); // 往hdfs输出
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    // hdfs的下载
    @Override
    public boolean download(OutputStream out, String path) {
        FileSystem fs = null;
        try {
            fs = FileSystem.get(this.getConfiguration());
            InputStream in = fs.open(new Path(this.BASE_PATH + "/" +path)); // 以流的形式打开文件 并进行读写操作
            IOUtils.copyBytes(in, out, 4096, true); // 往指定路径下载
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
