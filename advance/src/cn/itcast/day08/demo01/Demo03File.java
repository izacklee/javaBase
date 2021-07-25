package cn.itcast.day08.demo01;

import java.io.File;

/*  
    File类常用的方法：
        public String getAbsolutePath() :返回此File的绝对路径名字符串。 
        public String getPath() :将此File转换为路径名字符串。
        public String getName() :返回由此File表示的文件或目录的名称。 
        public long length() :返回由此File表示的文件的长度。
            注意：
                a.文件夹是没有大小概念的（查看详情显示的大小，是文件夹里文件的大小），不能获取文件夹大小
                b.如果构造方法中给出的路径不存在，那么length方法返回0
*/
public class Demo03File {
    
    public static void main(String[] args) {
//        show01();
//        show02();
//        show03();
        show04();
    }

    // public long length() :返回由此File表示的文件的长度。
    private static void show04() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/demo01/Demo02File.java");
        System.out.println(file.length()); // 4084  文件大小 单位：字节

        File file1 = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/demo01/123.txt");
        System.out.println(file1.length()); // 0 文件不存在返回0
    }

    // public String getName() :返回由此File表示的文件或目录的名称。
    private static void show03() {

        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/");
        System.out.println(file.getName()); // basic-code
        File file1 = new File("/Users/app/Downloads/javaproject/javatest/basic-code/Demo02File.java");
        System.out.println(file1.getName()); // Demo02File.java


    }

    // public String getPath() :将此File转换为路径名字符串。
    // 源码toString方法调用的就是getPath方法
    private static void show02() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/Demo02File.java");
        // 传什么返回什么
        System.out.println(file.getPath()); // /Users/app/Downloads/javaproject/javatest/basic-code/Demo02File.java
        File file1 = new File("Demo02File.java");
        System.out.println(file1.getPath());// Demo02File.java
        System.out.println(file1.toString()); // Demo02File.java
    }

    // public String getAbsolutePath() :返回此File的绝对路径名字符串。 
    private static void show01() {
        File file = new File("Demo02File.java");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath); // /Users/app/Downloads/javaproject/javatest/basic-code/Demo02File.java


    }

}
