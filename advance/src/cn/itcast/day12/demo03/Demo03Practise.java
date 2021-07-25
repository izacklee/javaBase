package cn.itcast.day12.demo03;

import java.util.function.Supplier;

/*
    练习：求数组中元素的最大值
        使用 Supplier 接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。
        提示:接口的泛型请使用 java.lang.Integer 类。
*/
public class Demo03Practise {

    public static void main(String[] args) {
        // 定义一个数组
        Integer[] arr = {10, 298, 300, 56, 2, 9, 12};
        // 使用Lambda表达式
        Integer max1 = getMax(()->{
            // 初始取数组第一个值做为最大值
            Integer m = arr[0];
            // 遍历数组
            for (int i = 1; i < arr.length; i++) {
                // 如果当前值比最大值还大，那么替换max
                if (arr[i] > m) {
                    m = arr[i];
                }
            }
            return m;
        });
        System.out.println(max1);
    }

    // 定义一个方法，用于获取int类型数组中元素的最大值，方法的参数传递Supplier，泛型使用Integer
    public static Integer getMax(Supplier<Integer> sup) {
        return sup.get();
    }

}
