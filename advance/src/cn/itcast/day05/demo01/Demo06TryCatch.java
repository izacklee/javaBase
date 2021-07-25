package cn.itcast.day05.demo01;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    try...catch：异常处理的第二种方式，自己处理
    格式：
        try {
            可能产生异常的代码
        } catch (异常类名 变量名) {
            异常的处理逻辑，产生异常对象之后，怎么处理异常对象
            一般在工作中，会把异常信息记录到一个日志中
        }
        ...
        catch (异常类名 变量名) {

        }
    注意：
        1.try可能会抛出多个异常对象，那么可以使用多个catch来处理这些异常对象
        2.如果try中产生了异常，那么就会执行catch中的异常处理逻辑，执行完catch中的逻辑，继续执行try...catch之后的代码
            如果try中没有产生异常，那么就不会执行catch中异常的处理逻辑，执行完try中的代码，继续执行try...catch之后的代码

*/
public class Demo06TryCatch {

    public static void main(String[] args) {
       /* // 1.多个异常分别处理
        // 注意：分别处理，异常的类必须都写的父类，否则报错
        try {
            // 可能产生异常的代码
            readFile("d:\\a.txt");
        } catch (IOException f) {
            System.out.println("catch - 传递的文件路径不是c:\\\\");
        }
        try {
            // 可能产生异常的代码
            readFile("d:\\a.txt");
        } catch (IOException io) {
            System.out.println("catch - 传递的文件后缀不是.txt");
        }*/

        // 2.多个异常一次捕获，多次处理
        // 调用声明异常对象的方法，声明了几个异常对象，那么try...catch就需要写几个
        /*
            注意：
                1.对于处理多个异常对象时，catch括号里的异常对象必须是先写子类再写父类
                FileNotFoundException extend IOException
                所以写FileNotFoundException再写IOException
                原因：原因是父类写在前面，无论父类子类抛出异常都会走父类的catch，子类在后面就不会再执行，所以就报错！
         */
//        try {
//            // 可能产生异常的代码
//            readFile("d:\\a.txt");
//        } catch (FileNotFoundException f) {
//            System.out.println("catch - 传递的文件路径不是c:\\\\");
//        } catch (IOException io) {
//            System.out.println("catch - 传递的文件后缀不是.txt");
//        }

        // 3.多个异常，一次捕获，一次处理
        // 注意：异常类名必须写父类
        /*try {
            // 可能产生异常的代码
            readFile("c:\\a.tx");
        } catch (Exception f) { // 写IOException或Exception都行
           f.printStackTrace();
        }*/

        // 运行时的异常可以不处理，即不捕获也不声明抛出，默认交给JVM处理
        int[] arr = {1, 2, 3};
        System.out.println(arr[3]); // java.lang.ArrayIndexOutOfBoundsException: 3

        System.out.println("后续代码，执行了！");
    }

    /*
       定义一个方法，对传递的文件路径进行合法性判断
       如果路径不是"c:\\"， 那么我们就抛出文件找不到异常对象，告知方法的调用者
       注意：
           FileNotFoundException是编译异常，抛出了编译异常，就必须处理这个异常
           可以使用throws继续声明抛出FileNotFoundException这个异常对象，让方法的调用者处理
   */
    private static void readFile(String fileName) throws FileNotFoundException, IOException {
        // 路径模糊匹配
        if (fileName.indexOf("c:\\")<0) {
            throw new FileNotFoundException("传递的文件路径不是c:\\\\"); // 编译期异常 需要throws声明
        }

        /*
            如果传递的路径，不是.txt结尾
            那么我们就抛出IO异常对象，告知方法调用者，文件的后缀名不对
        */
        if (fileName.indexOf(".txt")<0) {
            throw new IOException("不是.txt结尾的文件");  // 编译期异常，需要throws声明
        }

        System.out.println("路径没有问题，读取文件！");
    }

}
