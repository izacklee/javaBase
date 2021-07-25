package cn.itcast.day05.demo04;

/*
一个方法可以有0、1、多个参数；但是只有0或者1个返回值，不能有多个返回值。
如果希望一个方法当中返回多个结果，怎么办？
解决方案：使用一个数组作为返回值类型即可。

任何数据类型都能作为方法的参数类型，或者返回值的类型。
数组作为方法的参数，传递进去的其实就是数组的地址值。
数组作为方法的返回值，返回的其实就是数组的地址值。
*/
public class Demo02ArrayReturn {
    public static void main(String[] args) {
        int[] result = calculate(10, 20, 30);
        System.out.println("总和为：" + result[0]);
        System.out.println("平均值为：" + result[1]);
    }

    public static int[] calculate(int a, int b, int c) {
        int sum = a + b + c; // 总和
        int avg = sum / 3; // 平均值
        int[] array = { sum, avg };

        return array;

    }
}
