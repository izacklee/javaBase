package cn.itcast.day13.demo10;

import java.util.Arrays;

/*
    数组的构造器引用
*/
public class Demo01ArrayBuilder {

    public static void main(String[] args) {
        // 调用createArray方法，参数传递Lambda表达式
        int[] arr = createArray(10,len->{
            return new int[len];
        });
        System.out.println(Arrays.toString(arr)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(arr.length); // 10

        // 使用数组的构造器引用优化
        /*
            创建int[]数组 已知
            数组的长度 已知
            所以就可以使用数组的构造器引用
            int[]引用new，根据参数传递的长度创建数组
        */
        int[] arr1 = createArray(6,int[]::new);
        System.out.println(arr1.length); // 6

    }

    /*
        定义一个方法
            方法名称：createArray()
            返回值类型：int[]
            参数列表：int length, ArrayBuilder ab
    */
    public static int[] createArray(int length, ArrayBuilder ab) {
       return ab.builderArray(length);
    }

}
