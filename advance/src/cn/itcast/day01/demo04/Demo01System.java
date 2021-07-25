package cn.itcast.day01.demo04;

import java.util.Arrays;

/*
java.lang.System类：类包含一些有用的类字段和方法。它不能被实例化。类有final关键字修饰。
    常用方法：
        static long	currentTimeMillis() ：返回以毫秒为单位的当前时间。
        static void	arraycopy(Object src, int srcPos, Object dest, int destPos, int length) ：
          从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束
          参数：
            src - 源数组。
            srcPos - 源数组中的起始位置。
            dest - 目标数组。
            destPos - 目标数据中的起始位置。
            length - 要复制的数组元素的数量。
*/
public class Demo01System {
    public static void main(String[] args) {
//        demo01();
        demo02();
    }
    // arraycopy：将数组中指定的数据拷贝到另一个数组中。
    /*
     练习：
        将源数组中前3个元素，复制到目标数组的前3个位置上
        复制前：
            源数组（scr）：[1, 2, 3, 4, 5]
            目标数组（dest）：[6, 7, 8, 9 10]
        复制后：
            源数组（src）：[1, 2, 3, 4 ,5]
            目标数组（dest）：[1, 2, 3, 9, 10]
    */
    private static void demo02() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};

        // 复制前
        System.out.println(Arrays.toString(dest)); // [6, 7, 8, 9, 10]
        System.arraycopy(src, 0, dest, 0 ,3);

        // 复制后
        System.out.println("==============");
        System.out.println(Arrays.toString(dest)); // [1, 2, 3, 9, 10]
        System.out.println("==============");

        // 合并数组
        int[] all = new int[10];
        System.arraycopy(src,0,all,0,src.length);
        System.arraycopy(dest,0,all,5,dest.length); // [1, 2, 3, 4, 5, 1, 2, 3, 9, 10]
        System.out.println(Arrays.toString(all));
    }

    /*
     currentTimeMillis方法：用来测试程序的效率
     练习：
        验证for循环打印数字1~9999所需要使用的时间（毫秒）
    */
    private static void demo01() {
        // 程序执行前，获取一次毫秒
        long s = System.currentTimeMillis();
        // 执行for循环
        for (int i = 1; i < 10000; i++) {
            System.out.println(i);
        }
        // 程序执行后，再获取一次毫秒
        long e = System.currentTimeMillis();
        // 耗时（毫秒） = 程序执行后毫秒 - 程序执行前毫秒
        long result = e - s;
        System.out.println("程序运行耗时：" + result + "毫秒"); // 程序运行耗时：147毫秒
    }
}
