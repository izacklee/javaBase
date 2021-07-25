package cn.itcast.day07.demo02;

import java.util.Scanner;

public class Demo02Anonymous {
    public static void main(String[] args) {
        // 使用普通方式
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("1输入的是：" + num);
        System.out.println("================");

        // 匿名对象的方式
        int num1 = new Scanner(System.in).nextInt();
        System.out.println("2输入的是：" + num1);
        System.out.println("================");

        // 使用一般的写法传入
        Scanner sc1 = new Scanner(System.in);
        methodParam(sc1);

        System.out.println("================");

        // 使用匿名对象传参的写法
        methodParam(new Scanner(System.in));

        System.out.println("================");

        // 将匿名对象作为返回值的写法
        Scanner sc2 = methodReturn();
        int num2 = sc2.nextInt();
        System.out.println("5输入的是：" + num2);
    }

    public static void methodParam(Scanner sc) {
        int num = sc.nextInt();
        System.out.println("3-4输入的是：" + num);
    }

    public static Scanner methodReturn() {
        return new Scanner(System.in);
    }


}
