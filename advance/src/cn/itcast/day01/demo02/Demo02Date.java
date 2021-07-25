package cn.itcast.day01.demo02;

import java.util.Date;

public class Demo02Date {

    public static void main(String[] args) {
//        demo01();
//        demo02();
        demo03();
    }
    /*
     long	getTime() :把当前时间转换为毫秒数
    */
    private static void demo03() {
        Date d = new Date();
        System.out.println(d); // Tue Oct 08 23:03:38 CST 2019
        long m = d.getTime();
        System.out.println(m); // 1570547018790
    }

    // Date(long date)
    // 参数long date：意思是长整型的时间 毫秒
    private static void demo02() {
        Date d = new Date(1000L);
        System.out.println(d); // Thu Jan 01 08:00:01 CST 1970
    }

    // Date类 无参数的构造方法
    // Date() 获取当前系统时间
    private static void demo01() {
        Date d = new Date();
        System.out.println(d); // Tue Oct 08 22:53:27 CST 2019
    }
}
