package cn.itcast.day08.demo03;

import java.io.File;
import java.io.FileFilter;

// 定义一个FileFilter的接口实现类，重写accept方法，自定义重写规则
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        /*
            过滤规则：
                在accept方法中，判断File对象是否以.java结尾
                是返回true
                不是返回false
        */
        // 如果是文件家的话也返回true
        return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
    }
}
