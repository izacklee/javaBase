package cn.itcast.day05.demo01;

import java.util.Objects;

/*
    Object类中的静态方法
    public static <T> T requireNonNull(T obj)： 查看指定引用对象不是null

    源码：
    public static <T> T requireNonNull(T obj) {
           if (obj == null)
               throw new NullPointerException();
           return obj;
    }
*/
public class Demo04Objects {

    public static void main(String[] args) {
        int[] arr = null;
//        int[] arr = {1, 2, 3};
        // 查看指定对象不是空
//        Objects.requireNonNull(arr); // java.lang.NullPointerException
        Objects.requireNonNull(arr,"传递的数组对象是null"); // java.lang.NullPointerException: 传递的数组对象是null

        System.out.println(arr);
    }

}
