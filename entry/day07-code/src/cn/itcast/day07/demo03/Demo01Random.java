package cn.itcast.day07.demo03;

import java.util.Random;
/*
使用Random类来生成随机数。

使用起来也是三个步骤：
    1.导包
        import 包路径.类名称
        import java.util.Random;
    2.创建
        类名称 对象名 = new 类名称();
        Random r = new Random();
    3.使用
        获取一个随机的int数字（范围是int所有范围，有正负两种）：int num = r.nextInt();
        获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num = r.nextInt(3);
        实际上代表的含义是[0, 2)，也就是0~2
*/

public class Demo01Random {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt();
        System.out.println("Random生成的随机数是：" + num);
    }
}
