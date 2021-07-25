package cn.itcast.day01.demo03;

import java.util.Calendar;
import java.util.Date;

/*
java.util.Calendar类：日历类

Calendar类是一个抽象类，里面提供了很多操作日历的方法（YEAR、MONTH、DAY_OF_MONTH、HOUR）
Calendar类是一个抽象类，无法创建对象使用，里面有一个静态方法getInstance()，该方法返回了Calendar类的子类对象
static Calendar	getInstance()：使用默认时区和语言环境获得一个日历。

*/
public class Demo01Calendar {
    public static void main(String[] args) {
        // 使用Calendar类的静态方法getInstance()，获取子类对象
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar); // java.util.GregorianCalendar[time=1570587102416...
    }
}
