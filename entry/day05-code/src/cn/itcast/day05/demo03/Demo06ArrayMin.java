package cn.itcast.day05.demo03;

public class Demo06ArrayMin {
    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 100, 10000, 200, -2, 12 };
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果当前元素值比指定min的小，那么将其赋给min
            if ( array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("最小值为：" + min);
    }
}
