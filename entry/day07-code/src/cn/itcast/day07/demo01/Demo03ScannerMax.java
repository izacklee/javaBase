package cn.itcast.day07.demo01;

/*
题目：键盘输入三个数字，然后求出其中最大值。

思路：
    1.用键盘输入，那就需要用到Scanner
    2.用Scanner的三个步骤：导包、创建、使用
    3.需要的是三个数字，那么就要调用三次nextInt()方法，得到三个int类型变量
    4.无法同时判断三个数谁最大，那么就应该转换为下面两个步骤：
        4.1.首先判断前两个数谁最大，拿到前两个数的最大值
        4.2.将拿到前两个数的最大值，再和第三个数比较大小，最终得出三个数当中的最大值
    5.打印最终结果
*/

import java.util.Scanner;

public class Demo03ScannerMax {
    public static void main(String[] args) {
        // System.in代表使用键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数字：");
        int a = sc.nextInt();
        System.out.print("请输入第二个数字：");
        int b = sc.nextInt();
        System.out.print("请输入第三个数字：");
        int c = sc.nextInt();
        // 首先比较前两个数的最大值，得到最大值
        int temp = a > b ? a : b;
        // 再将前两个数的最大值与第三个数做比较，最终得出三个数当中的最大值
        int max = temp > c ? temp : c;

        System.out.println("三个数中的最大值是：" + max);
    }
}
