package cn.itcast.day05.demo03;

/*
如果获取数组长度，格式：
数组名称.length

这将会得到一个int数字，代表数组的长度。

数组一旦创建，程序运行期间，长度不可改变。
*/

public class Demo03ArrayLength {
    public static void main(String[] args) {
        int[] arrayA = new int[3];
        int[] arrayB = { 1, 2, 3, 5 };
        int len = arrayB.length;
        System.out.println("arrayB数组长度是：" + len); // 4

        int[] arrayC = new int[2];
        System.out.println(arrayC.length); // 2
        arrayC = new int[3];
        System.out.println(arrayC.length); // 3
    }
}
