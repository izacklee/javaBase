package cn.itcast.day09.demo04;

import java.io.FileWriter;
import java.io.IOException;

/*
    在JDK1.7之前使用try catch finally 处理流中的异常
    格式：
        try{
            // 可能会产生异常的代码
        } catch (异常类名 变量名) {
            // 异常处理逻辑
        } finally {
            // 一定会执行的代码
            // 资源释放
        }
*/
public class Demo01TryCatch {

    public static void main(String[] args) {
        // 把变量放在try外面，提升作用域
        // 变量定义时可不赋值，但是在使用的时候必须赋值
        // fw = new FileWriter("advance/src/cn/itcast/day09/test/f.txt",true); 执行失败，fw没有值，fw.close会报错
        FileWriter fw = null;
        try {
            fw = new FileWriter("advance/src/cn/itcast/day09/test1/f.txt",true);

            for (int i = 0; i < 10; i++) {
                fw.write("HelloJava" + i + "\r");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 如果创建对象失败了 那么fw就为null，null是不能调用方法的，会抛出java.lang.NullPointerException
            // 需要增加一个判断，不等于null时才释放资源
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
