package cn.itcast.day03.demo03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
   java.util.Collections是集合工具类，用来对集合进行操作。部分方法如下：
   public static <T> boolean addAll(Collection<? super T> c, T... elements) ：将所有指定元素添加到指定 collection 中。
   public static void shuffle(List<?> list) ：使用默认随机源对指定列表进行置换（打乱集合顺序）。
*/
public class Demo01Collections {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 向集合中批量添加元素
        Collections.addAll(list,1, 2, 3, 4);
        System.out.println(list); // [1, 2, 3, 4]

        // 打乱集合的顺序
        Collections.shuffle(list);
        System.out.println(list); // [2, 4, 3, 1]

    }

}
