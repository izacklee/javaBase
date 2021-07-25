package cn.itcast.day08.demo01;

import java.io.File;

/*
    路径：
        绝对路径：是一个完整的路径
            以盘符（C:, D:）开始的路径
                C:\a.txt
                D:\demo\b.txt
        相对路径：是一个简化的路径
            相对指的是相对于当前项目的根目录（C:\Users\itcast\IdeaProject\javaProject）
            如果使用当前项目的根目录，路径可以简化书写
            C:\Users\itcast\IdeaProject\javaProject\123.txt --> 简化为： 123.txt（可以省略项目的根目录）
        注意：
            1.路径是不区分大小写
            2.路径中的文件名称分隔符windows使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠

        构造方法：
            File(String pathname) ：通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
                参数：
                    String pathname：字符串的路径名称
                    路径可以是以文件结尾，也可以是文件夹结尾
                    路径可以是相对路径，也可以是绝对路径
                    路径是可以存在的，也可以不存在的
                    创建File对象，只是把字符串路径封装为File对象，不考虑路径的真假
            File(String parent, String child)：根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
                参数：把路径分为两部分
                    String parent：父路径
                    String child：子路径
                好处：
                    父路径和子路径，可以单独写，使用起来非常灵活，父路径和子路径都可以变化
            File(File parent, String child)：根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
                参数：把路径分成两部分
                    File parent：父路径
                    String child：子路径
                好处：
                    父路径和子路径，可以单独写，使用起来非常灵活，父路径和子路径都可以变化
                    父路径是File类型，可以使用File的方法对路径进行一些操作，再使用路径创建对象

*/
public class Demo02File {

    public static void main(String[] args) {

        show03();
       /* show02("/Users/app/Downloads/javaproject/javatest", "/basic-code/" +
                "advance/src/cn/itcast/day08/demo01/Demo02File.java");*/
//        show01("/Users/app/Downloads/javaproject/javatest/basic-code/" +
//                "advance/src/cn/itcast/day08");
//        show01("123.java");
    }

    // File(File parent, String child)：根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
    private static void show03() {
        File parent = new File("/Users/app/Downloads/javaproject/javatest");
        File file = new File(parent,"/basic-code/advance/src/cn/itcast/day08/demo01/Demo02File.java");
        // /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/demo01/Demo02File.java
        System.out.println(file);

    }

    // File(String parent, String child)：根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
    private static void show02(String parent, String child) {
        File file = new File(parent, child);
        // /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/demo01/Demo02File.java
        System.out.println(file);

    }

    // File(String pathname) ：通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
    private static void show01(String filename) {
//        File file = new File(filename);
//        System.out.println(file); // /Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08

        File file1 = new File(filename);
        System.out.println(file1); // 123.java

    }

}
