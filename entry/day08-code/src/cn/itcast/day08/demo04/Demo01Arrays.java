package cn.itcast.day08.demo04;
import java.util.Arrays;

/*
 java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。

 public static String toString(数组)：将参数数组变为字符串（按照默认格式：[元素1, 元素2, 元素3...]）
 public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序。

注意事项：
1.如果是数值，sort默认按升序小到大
2.如果是字符串，sort默认按字母升序
3.如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（今后学习）
*/
public class Demo01Arrays {
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        String str = Arrays.toString(array);
        System.out.println(str); // [10, 20, 30]

        // 将数组升序排序
       int[] array1 = {1, 2, 6, 3, 4};
        Arrays.sort(array1);
        String str1 = Arrays.toString(array1);
        System.out.println(str1); // [1, 2, 3, 4, 6]

        String[] array2 = {"aaa", "ccc", "bbb"};
        Arrays.sort(array2);
        String str2 = Arrays.toString(array2);
        System.out.println(str2); // [aaa, bbb, ccc]

        // 将数组比较是否相等
        int[] array3 = {10, 20, 30};
        System.out.println(Arrays.equals(array, array1)); // false
        System.out.println(Arrays.equals(array, array3)); // true

        // 填充数组的值（给定一个值来覆盖数组中所有的值）
        Arrays.fill(array3, 2);
        System.out.println(Arrays.toString(array3)); // [2, 2, 2]

        // 复制数组
        int[] array4 = {20, 70, 50, 60};
        int[] array5 = Arrays.copyOf(array4, 6);
        System.out.println(Arrays.toString(array5)); // [20, 70, 50, 60, 0, 0]

        // 根据值查找该值在数组中的位置，并返回其索引值
        // 使用Arrays中的binarySearch方法，必须先对数组排序，否则查出来的值错误！因为该方法的核心是二分查找，必须是有序数组才行。
        Arrays.sort(array4);
        System.out.println(Arrays.toString(array4)); // [20, 50, 60, 70]
        int index = Arrays.binarySearch(array4, 50);
        int index2 = Arrays.binarySearch(array4, 80);
        System.out.println(index); // 1
        System.out.println(index2); // -5

    }
}
