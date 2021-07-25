package cn.itcast.day12.demo02;

import java.util.Arrays;
import java.util.Comparator;

/*
    如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个Lambda表达式。
    当需要通过一个方法来获取一个 java.util.Comparator 接口类型的对象作为排序器时,就可以调该方法获取。
*/
public class Demo03Comparator {

    public static void main(String[] args) {
        String[] arr = {"ccc","ssssrrr","ghtaa"};
        System.out.println("原数组：" + Arrays.toString(arr));
        Arrays.sort(arr,getComparable());
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

    // 定义一个方法，返回值类型为Comparator接口
    public static Comparator<String> getComparable() {

        // 方法返回值是一个接口，那么我们可以返回这个接口的匿名内部类
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1,String o2) {
//                // 按照字符串降序排序
//                return o2.length() - o1.length();
//            }
//        };

        // 使用Lambda方式，简化写法
        return (o1,o2)->o2.length() - o1.length();
    }

}
