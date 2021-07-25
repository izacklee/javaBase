package cn.itcast.day08.demo04;

/*
java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算的相关操作。

public static double abs(double num)： 获取绝对值。
public static double ceil(double num)：向上取整。
public static double floor(double num)：向下取整。
public static long round(double num)：四舍五入。

Math.PI代表近似的圆周率常量（double）。
*/
public class Demo03Math {
    public static void main(String[] args) {
        // 获取绝对值
        System.out.println(Math.abs(3.14)); // 3.14
        System.out.println(Math.abs(0)); // 0
        System.out.println(Math.abs(-1)); // 1
        System.out.println("=============");

        // 向上取整
        System.out.println(Math.ceil(5.1)); // 6.0
        System.out.println(Math.ceil(5.5)); // 6.0
        System.out.println(Math.ceil(-5.9)); // -5.0
        System.out.println("=============");

        // 向下取整 抹零
        System.out.println(Math.floor(1.8)); // 1.0
        System.out.println(Math.floor(1)); // 1.0
        System.out.println(Math.floor(-2.5)); // -3.0
        System.out.println("=============");

        // 四舍五入
        System.out.println(Math.round(2.2)); // 2
        System.out.println(Math.round(2.5)); // 3
        System.out.println(Math.round(-1.8)); // -2

        // 圆周率
        System.out.println(Math.PI); // 3.141592653589793
    }
}
