package cn.itcast.day01.demo03;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;

/*
Calendar类的成员方法：
    public int get(int field)：返回给定日历字段的值
        参数：
            int field：传递指定的日历字段（YEAR, MONTH...）
        返回值：日历字段代表具体的值
    public void set(int field, int value)：将给定的日历字段设置为给定的值
        参数：
            int field：传递指定的日历字段（YEAR, MONTH...）
            int value：传递的字段设置具体的值
    public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量
        参数：
            int field：传递指定的日历字段（YEAR, MONTH...）
            int amount：增加/减少的值
                正数：增加
                负数：减少
    public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象
        把日历对象，转换为日期对象
*/
public class Demo02Calendar {
    public static void main(String[] args) {
//        demo01();
//        demo02();
//        demo03();
        demo04();
    }

    // getTime方法
    private static void demo04() {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time); // Wed Oct 09 10:56:12 CST 2019
    }

    // add方法
    private static void demo03() {
        Calendar calendar = Calendar.getInstance();
        // 当前日期增加1年
        calendar.add(Calendar.YEAR, 1);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year); // 2020

        // 当前日期减少2个月
        calendar.add(Calendar.MONTH, -2);
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println(month); // 8

    }

    // set方法
    private static void demo02() {
       Calendar calendar = Calendar.getInstance();
       calendar.set(Calendar.YEAR, 2018);
       int year = calendar.get(Calendar.YEAR);
        System.out.println(year); // 2018

        // 可以同时设置年月日
        calendar.set(2018, 8, 1);
        String today = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(today); // 2018-8-1
    }

    /*
        get方法
    */
    private static void demo01() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        System.out.println(year); // 2019

        // 注意：月份中国是东八区要+1
        // 中国的月份是（1~12），西方国家的月份是（0~11）
        int month = calendar.get(calendar.MONTH) + 1;
        System.out.println(month); // 10

        int date = calendar.get(calendar.DATE);
        System.out.println(date); // 9

    }
}
