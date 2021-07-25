package cn.itcast.day04.demo05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    JDK9的特性：
        List接口，Set接口，Map接口：里边增加了一个静态方法of，可以给集合一次性添加多个元素
        static <E> List<E> of (E...elements)
        使用前提：
            当集合存储的元素个数已经确定，不再改变时使用
        注意：
            1.of方法只适用于List接口，Set接口，Map接口，不适用于接口的实现类以及父类
            2.of方法的返回值是一个不能改变的集合，集合不能在使用add，put方法添加元素，会抛出异常
            3.Set接口和Map接口在调用方法的时候，不能有重复的元素，否则会抛出异常
*/
public class Demo01Of {

    public static void main(String[] args) {
        List<String> list =List.of("a", "c", "b", "d");
        System.out.println(list); // [a, c, b, d]
//        list.add("f"); // 错误！ UnsupportedOperationException不支持操作异常

        Set<Integer> set = Set.of(1 ,3, 2);
        System.out.println(set); // [3, 2, 1]
//        set.add(4); // 错误！ UnsupportedOperationException不支持操作异常

        /*Set<Integer> set1 = Set.of(1 ,3, 2, 3);
        System.out.println(set1); // IllegalArgumentException非法参数操作异常 有重复
        */

        Map<String,Integer> map = Map.of("王丽坤", 166, "迪丽热巴",166,"古力娜扎",168);
        System.out.println(map); // {迪丽热巴=166, 古力娜扎=168, 王丽坤=166}
//        map.put("范冰冰",169); // // 错误！ UnsupportedOperationException不支持操作异常

    }

}
