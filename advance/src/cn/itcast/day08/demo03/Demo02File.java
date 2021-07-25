package cn.itcast.day08.demo03;

import java.io.File;
import java.io.FilenameFilter;

/*
    使用Lambda表达式优化程序
*/
public class Demo02File {
    public static void main(String[] args) {
        File f = new File("/Users/app/Downloads/javaproject/javatest/basic-code" +
                "/advance/src/cn/itcast/day08/test");
        printDir(f);
    }

    // 递归查找文件夹和子文件夹，以及里面包含的所有文件的方法
    private static void printDir(File file) {
        // 使用FilenameFilter接口，过滤文件名称
        // 匿名内部类的方式
//        File[] files = file.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                // 过滤规则fileName是文件夹或者文件，返回true
//                // 注意：这里的路径和文件是分开的，需要用File类封装，才能调用isDirectory方法
//                return new File(dir, name).isDirectory() || name.toString().toLowerCase().endsWith(".java");
//            }
//        });

         // 使用Lambda表达式优化
        // FilenameFilter 接口
         File[] files = file.listFiles((dir,  name) -> new File(dir, name).isDirectory() || name.toString().toLowerCase().endsWith(".java"));

         // FileFilter接口
//        File[] files = file.listFiles(fileName -> fileName.isDirectory() || fileName.getName().toLowerCase().endsWith(".java"));

        for (File f : files) {
            // 如果是目录，递归继续往下找
            if (f.isDirectory()) {
                printDir(f);
            } else {
                // 否则打印文件
                System.out.println("文件:" + f);
            }
        }
    }

}
