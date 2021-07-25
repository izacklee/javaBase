package cn.itcast.day08.demo01;

import java.io.File;

/*
    File判断功能的方法：
        public boolean exists() :此File表示的文件或目录是否实际存在。
        public boolean isDirectory() :此File表示的是否为目录。
        public boolean isFile() :此File表示的是否为文件。

        注意：
            1.isDirectory和isFile方法是互斥，返回的结果相反
            2.isDirectory和isFile方法路径必须存在，否则返回false
*/
public class Demo04File {

    public static void main(String[] args) {
//        show01();
//        show02();
        show03();
    }

    // public boolean isFile() :此File表示的是否为文件。
    // 此方法与isDirectory方法返回的结果相反
    private static void show03() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/demo01/Demo02File.java");
        System.out.println(file.isFile()); // true
        File file1 = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/demo01");
        System.out.println(file1.isFile()); // false
    }

    // public boolean isDirectory() :此File表示的是否为目录。
    // 此方法返回的结果与isFile相反
    private static void show02() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/demo01/Demo02File.java");
        System.out.println(file.isDirectory()); // false
        // 不存在就没必要获取
        if (file.exists()) {
            System.out.println(file.isDirectory());
        }
        File file1 = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/demo01");
        System.out.println(file1.isDirectory()); // true
    }

    // public boolean exists() :此File表示的文件或目录是否实际存在。
    private static void show01() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/demo01/Demo02File.java");
        System.out.println(file.exists()); // true
    }

}
