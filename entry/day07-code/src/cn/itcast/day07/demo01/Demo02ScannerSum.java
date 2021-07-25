package cn.itcast.day07.demo01;

import java.util.Scanner;

/*
题目：键盘输入两个数字int，并求出和值。

思路：
    1.既然要用键盘输入，那么就要用Scanner
    2.Scanner的三个步骤：导包、创建、使用
    3.需要的是两个数字，那么就要调用两次nextInt()方法
    4.将得到的两个数字，加在一起
    5.将结果打印输出

*/

public class Demo02ScannerSum {
    public static void main(String[] args) {
        // System.in的意思是代表从键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数字：");
        int a = sc.nextInt();
        System.out.print("请输入第二个数字：");
        int b = sc.nextInt();
        int result = a + b;
        System.out.println("两个数字的和是：" + result);
    }
}
