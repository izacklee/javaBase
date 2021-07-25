package cn.itcast.day05.demo01;

import java.util.Arrays;

/*
  二维数组

  简单理解就是一维数组中存的值是另一个一维数组。
*/
public class Demo06TwoDimensionalArray {

    public static void main(String[] args) {
        // 二维数组 第一种写法
        // 1.声明
        int[][] array; // 或 int array[][];都行
        // 2.开辟内存空间
        array = new int[2][3];
        // 3.赋值
        array[0][0] = 10;
        array[0][1] = 20;
        array[0][2] = 30;
        array[1][0] = 40;
        array[1][1] = 50;
        array[1][2] = 60;
        // Arrays类中的toString方法只对一维数组有效，所以输出结果一维数组中的值为地址值
        System.out.println(Arrays.toString(array)); // 输出结果：[[I@2471cca7, [I@5fe5c6f]

        // 第二种写法
        int[] item = {10, 20, 30};
        int[] item2 = {40, 50, 60};
        int[][] array2 = {item, item2};
        System.out.println(Arrays.toString(array2)); // [[I@6979e8cb, [I@763d9750]

        // 第三种写法 最简单 推荐！
//        int[][] array3 = {{10, 20, 30}, {40, 50, 60}};
        int[][] array3 = {{10, 20, 30, 40}, {40, 50, 60, 70, 80}}; // 二维数组里的长度可以不固定
        System.out.println(Arrays.toString(array3)); // [[I@5c0369c4, [I@2be94b0f]

        // 遍历数组
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                System.out.println(array3[i][j]);
            }
        }
    }
}
