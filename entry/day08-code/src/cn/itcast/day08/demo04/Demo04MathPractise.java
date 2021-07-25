package cn.itcast.day08.demo04;

/*
题目：
计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？

（小学解题方法：画数轴）

分析：
1.既然已经确定了范围，用for循环
2.起点位置-10.8应该转换成为-10，两种办法：
    2.1.可以使用Math.ceil方法，向上取整
    2.2.强制转换成int，自动舍弃所有小数位
3.每一个数字都是整数，所以步进表达式应该是num++，这样每次都是+1的。
4.如何拿到绝对值：Math.abs方法
5.一旦发现一个数字，需要让计数器++进行统计

备注：如果使用Math.ceil方法，-10.8可以变成-10.0。注意double值也是可以++的。
*/
public class Demo04MathPractise {
    public static void main(String[] args) {
        int num = 0;
        // 这样处理，i就是区间内所有整数
        for (int i = (int) -10.8; i < 5.9; i++ ) {
            double d = Math.abs(i); // 绝对值
            if (6 < d || d < 2.1) {
                num++;
            }
        }
        System.out.println("整数的个数：" + num);
    }
}
