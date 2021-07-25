package cn.itcast.day08.demo01;

import java.io.File;
import java.io.IOException;

/*
    创建删除功能的方法：
        public boolean createNewFile() :当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
            注意：
                1.此方法只能创建文件，不能创建文件夹
                2.创建文件的路径必须存在，否则会抛出异常
        public boolean delete() :删除由此File表示的文件或目录。
            返回值：布尔值
                true：文件或文件夹删除成功
                false：文件夹中有内容，不会删除，返回false，构造方法中路径不存在返回false
            注意：
                1.删除的文件直接从硬盘删除，不走回收站，删除要谨慎
        public boolean mkdir() :创建由此File表示的目录。
            创建单级空文件夹
            注意：
                1.此方法只能创建文件夹，不能创建文件
                2.创建文件的路径必须存在，否则会抛出异常
        public boolean mkdirs() :创建由此File表示的目录，包括任何必需但不存在的父目录。
            即可以创建单级文件夹，也可以创建多级文件夹
            注意：
                1.此方法只能创建文件夹，不能创建文件
                2.创建文件的路径必须存在，否则会抛出异常
*/
public class Demo05File {

    public static void main(String[] args) {
//        show01();
//        show02();
        show03();
    }

    // public boolean delete() :删除由此File表示的文件或目录。
    private static void show03() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/test/新建文件夹");
        System.out.println(file.delete()); // true

        File file1 = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/test/1");
        System.out.println(file1.delete()); // false 文件夹含有文件不能删除
    }

    /*
        public boolean mkdir() :创建由此File表示的目录。
        public boolean mkdirs() :创建由此File表示的目录，包括任何必需但不存在的父目录。
    */
    private static void show02() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/test/1.txt");
        File file1 = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/test/1/2/3/a.txt");
        System.out.println(file.mkdir()); // true 结果创建了名称为“1.txt”的文件夹
        System.out.println(file1.mkdirs()); // true 结果创建了1/2/3/a.txt这四个有层级关系的文件夹

    }

    // public boolean createNewFile() :当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
    private static void show01() {
        File file = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/test/123.txt");
        File file1 = new File("/Users/app/Downloads/javaproject/javatest/basic-code/" +
                "advance/src/cn/itcast/day08/test/新建文件夹");
        try {
            // 注意：创建文件的路径不存在，则抛出java.io.IOException: No such file or directory
            System.out.println(file.createNewFile()); // true

            // 路径为“新建文件夹”结尾，其实创建的也是文件，名称就为“新建文件夹”，不要被名称误导
            System.out.println(file1.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
