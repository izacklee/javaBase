package cn.itcast.day01.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.util.DateFormat：是日期/时间格式化子类的抽象类

作用：
    格式化（也就是日期 -> 文本）、解析（文本-> 日期）
成员方法：
    String	format(Date date) ：将一个 Date 格式化为日期/时间字符串。日期 -> 文本
    Date	parse(String source) ：从给定字符串的开始解析文本，以生成一个日期。文本-> 日期

注意：DateFormat是一个抽象方法，不能直接new使用，需要用它的子类SimpleDateFormat

    SimpleDateFormat(String pattern) ：用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
    参数String pattern：传入指定的模式
    模式例如："yyyy-MM-dd HH:mm:ss" 或 "yyyy年MM月dd日 HH时:mm分:ss秒"
    注意：模式中的字母不能改，模式中的连接字符串可以改。

使用parse方法时会有红色波浪下划线提示， 原因是parse声明了一个叫ParseException的异常
    如果字符串和构造方法中的模式不一样，那么程序就会抛出异常
    调用了一个抛出异常的方法，就必须得处理这个异常，两种处理方式：
        a.用throws继续声明抛出一个异常
        b.写try...catch自己处理这个异常
*/
public class Demo03DateFormat {

    public static void main(String[] args) throws ParseException {
        demo01();
    }
    // 使用parse处理异常方式之一，在方法名称后面加上：throws ParseException
    private static void demo01() throws ParseException {
        // 日期 -> 文本
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String text = sdf.format(d);
        System.out.println(text); // 2019-10-08 23:35:02

//        text = "2019年10月08日 23:35:02";  // 错误写法！与SimpleDateFormat参数定义的模式不一致
//        text = "2019-10-08 23:35:02"; // 正确写法

        // 文本 -> 日期
        Date date = sdf.parse(text);
        System.out.println(date); // Tue Oct 08 23:35:02 CST 2019

    }

}
