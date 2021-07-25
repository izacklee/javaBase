package cn.itcast.day08.demo02;

import java.io.File;

/*
    练习：
        递归打印多级目录
    需求：
        遍历/Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test文件夹，
        及test文件夹的子文件夹

            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/.DS_Store
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1/.DS_Store
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1/2
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1/2/.DS_Store
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1/2/3
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1/2/3/.DS_Store
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1/2/3/a.txt
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1/2/3/a.txt/b.txt
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1.txt
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/1.txt/hello.java
            /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test/123.txt
*/
public class Demo04RecursionPractise {

    public static void main(String[] args) {
        File f = new File("/Users/app/Downloads/javaproject/javatest/basic-code" +
                "/advance/src/cn/itcast/day08/test");
        printDir(f);
    }

    // 递归查找文件夹和子文件夹，以及里面包含的所有文件的方法
    private static void printDir(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            // 如果是目录，递归继续往下找
            if (f.isDirectory()) {
                System.out.println("目录：" + f);
                printDir(f);
            } else {
                // 否则打印文件
                System.out.println("文件：" + f);
            }
        }
    }

}
