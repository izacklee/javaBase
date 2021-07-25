package cn.itcast.day01.demo06;

/*
基本类型与字符串之间的转换

基本类型 -> 字符串
     1.基本类型的数据值+""，最简单的方式（工作中常用）
     2.使用包装类中的静态方法
        static String	toString(int i) ：返回一个表示指定整数的 String 对象。
     3.使用String中的静态方法
        static String	valueOf(int i) ：返回 int 参数的字符串表示形式。
字符串 -> 基本类型
    1.使用包装类中的静态方法parseXX("字符串")
        Integer类：static int parseInt(String s)
        Double类：static double parseDouble(String s)
        ...
*/
public class Demo03Integer {

    public static void main(String[] args) {
        // 基本类型 -> 字符串
        int num1 = 1;
        String str1 = num1 + "";
        String str2 = Integer.toString(num1);
        System.out.println("str1：" + str1); // str1：1
        System.out.println(str2 + 25); // 125

        // 字符串 -> 基本类型
        int num2 = Integer.parseInt(str2);
        System.out.println(num2 + 1); // 2

    }

}
