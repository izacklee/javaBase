package cn.itcast.day02.demo01;

import java.util.ArrayList;
import java.util.Collection;

/*
    java.util.Collection接口
        所有单列集合的最顶层的接口，里边定义了所有单例集合的共性方法
        任意的单例集合都可以使用Collection接口中的方法

    共性方法：
        public boolean add(E e) : 把给定的对象添加到当前集合中 。
        public void clear() :清空集合中所有的元素。
        public boolean remove(E e) : 把给定的对象在当前集合中删除。
        public boolean contains(E e) : 判断当前集合中是否包含给定的对象。
        public boolean isEmpty() : 判断当前集合是否为空。
        public int size() : 返回集合中元素的个数。
        public Object[] toArray() : 把集合中的元素，存储到数组中。
*/
public class Demo01Collection {

    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        // add 把给定的对象添加到当前集合中
        coll.add("王丽坤");
        coll.add("迪丽热巴");
        coll.add("古力娜扎");
        System.out.println(coll); // [王丽坤, 迪丽热巴, 古力娜扎]

        // contains 判断当前集合中是否包含给定的对象
        boolean con = coll.contains("迪丽热巴");
        System.out.println(con); // true

        // isEmpty 判断当前集合是否为空
        boolean is = coll.isEmpty();
        System.out.println(is); // false

        // size 返回集合中元素的个数
        int in = coll.size(); // 3

        // toArray 把集合中的元素，存储到数组中
        Object[] array = coll.toArray();
        System.out.println(array[0]); // 王丽坤

        // remove 把给定的对象在当前集合中删除
        boolean re = coll.remove("赵丽颖");
        System.out.println(re); // false

        // clear 清空集合中所有的元素，但是不删除集合，集合还存在
        System.out.println("清空前：" + coll); // 清空前：[王丽坤, 迪丽热巴, 古力娜扎]
        coll.clear();
        System.out.println("清空后：" + coll); // 清空后：[]

    }

}
