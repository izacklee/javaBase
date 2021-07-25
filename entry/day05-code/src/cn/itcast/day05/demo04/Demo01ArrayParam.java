package cn.itcast.day05.demo04;

/*
数组可以作为方法的参数。
当调用方法时，向方法的小括号里传参，传递进去的其实是数组的地址值。
*/
public class Demo01ArrayParam {
    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 5, 6 };
        printArray(array); // 这里传进去的array为数组的地址值
        System.out.println("=====AAA====");
        printArray(array);
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
