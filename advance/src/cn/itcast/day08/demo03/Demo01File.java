package cn.itcast.day08.demo03;

import java.io.File;
import java.io.FileFilter;

/*
    FileFilter文件过滤优化

    需求：
        遍历/Users/app/Downloads/javaproject/javatest/basic-code/advance/src/cn/itcast/day08/test文件夹，
        及test文件夹的子文件夹
        只要.java结尾的文件

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

    我们可以使用过滤器来实现
    在File类中有两个和ListFile重载的方法，方法的参数传递就是过滤器
    File[]	listFiles(FileFilter filter) ：返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
    java.io.FileFilter接口：用于抽象路径名（File对象）的过滤器
        作用：用来过滤文件（File对象）
        抽象方法：用来过滤文件的方法
            boolean accept(File pathname)：测试指定抽象路径名是否应该包含在某个路径名列表中。
                参数：
                    File pathname：使用ListFiles方法遍历目录，得到的每一个文件对象
    File[]	listFiles(FilenameFilter filter) ：返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
    java.io.FilenameFilter接口：实现此接口的类实例可用于过滤器文件名
        作用：用于过滤文件名称
        抽象方法：用来过滤文件的方法
            boolean accept(File dir, String name)：测试指定文件是否应该包含在某一文件列表中。
            参数：
                File dir：构造方法中传递的被遍历的目录
                String name：使用listFiles方法遍历目录，获取到的每一个文件/文件夹的名称

    注意：
        两个过滤器接口没有实现类，需要我们自己写实现类，重写accept方法，在方法中自己定义过滤规则
*/
public class Demo01File {

    public static void main(String[] args) {
        File f = new File("/Users/app/Downloads/javaproject/javatest/basic-code" +
                "/advance/src/cn/itcast/day08/test");
        printDir(f);
    }

    // 递归查找文件夹和子文件夹，以及里面包含的所有文件的方法
    private static void printDir(File file) {
        File[] files = file.listFiles(new FileFilterImpl()); // 传过滤器的对象
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
