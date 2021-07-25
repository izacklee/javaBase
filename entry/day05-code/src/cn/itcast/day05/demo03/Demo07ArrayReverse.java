package cn.itcast.day05.demo03;

/*
数组元素顺序的反转：
    本来的样子：[1, 2, 3, 4]
    之后的样子：[4, 3, 2, 1]

 要求不能使用新数组，就用原来的唯一一个数组。

*/

import java.sql.SQLOutput;

public class Demo07ArrayReverse {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4 };
        /*
            初始化语句：int min = 0, max = array.length - 1
            判断条件：min < max
            步进表达式：min++, max--
            循环体：用第三个变量倒手
        */
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        System.out.println("=================");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
