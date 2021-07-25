package cn.itcast.day05.demo03;

/*
数组的索引编号从0开始，一直到“数据的长度-1”为止。

如果访问数组元素的时候，引用编号不存在，那么将会发生
数组索引越界异常
ArrayIndexOutOfBoundsException

原因：索引编号写错了。
解决：修改成为存在的正确引用编号。
*/

import java.awt.*;

public class Demo01ArrayIndex {
    public static void main(String[] args) {
        int[] array = { 10, 20};
        System.out.println(array[0]); // 10

        //错误写法
        // 并不存在3号元素，所以发生异常
        System.out.println(array[2]);
    }
}
