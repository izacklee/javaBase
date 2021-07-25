package cn.itcast.day01.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
练习：
    请使用时间相关的API，计算出一个人已经出生了多少天。

思路：
    1.使用Scanner的next方法，获取输入的出生日期
    2.使用SimpleDateFormat的parse方法，将字符串的日期格式转换成Date日期
    3.将Date格式的出生日期转化为毫秒
    4.获取当前系统时间，毫秒
    5.用系统当前时间-出生日期
    6.把减法结果的毫秒值转换为天（s/1000/60/60/24）
*/
public class Demo04Practise {

    public static void main(String[] args) throws ParseException {
       /* // 获取昨天的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE,-1);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day1 = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "-" + month + "-" + day1);*/

        // 创建键盘输入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入出生日期，格式'yyyy-MM-dd'：");
        // 创建日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取当前输入的出生日期，并转换为Date格式
        Date birthday = sdf.parse(sc.next());
        // 把出生日期的Date转换为毫秒
        long s = birthday.getTime();
        // 获取系统当前日期 毫秒
//        Date d = new Date();
//        long e = sdf.parse(sdf.format(d)).getTime();
        // 换一种写法
//        long e = System.currentTimeMillis();
        // 再换一种写法
        long e = new Date().getTime();

        // 系统当前时间-出生日期
        long result = e - s;
        // 把毫秒值转换为天
        long day = result / 1000 / 60 / 60 / 24;
        System.out.println(day);
    }
}
