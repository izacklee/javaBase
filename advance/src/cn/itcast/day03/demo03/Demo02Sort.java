package cn.itcast.day03.demo03;

import java.util.ArrayList;
import java.util.Collections;

/*
    java.util.Collections是集合工具类，用来对集合进行操作。部分方法如下：
    public static <T extends Comparable<? super T>> void sort(List<T> list)：根据元素的自然顺序 对指定列表按升序进行排序。
    注意：
        只能对List集合进行排序，不能对Set集合排序。
        使用前提：对集合存储的内容中元素排序，必须实现Comparable接口，重写接口中的compareTo方法定义排序规则
    Comparable接口的排序规则：
        this.变量名 - 参数.变量名：升序排序
        参数.变量名 - this.变量名：降序排序

*/
public class Demo02Sort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        System.out.println(list); // [2, 1, 3]

        // 将集合升序排序
        Collections.sort(list);
        System.out.println(list); // [1, 2, 3]

        // 对Person中年龄元素排序
        Person p1 = new Person("王丽坤", 18);
        Person p2 = new Person("迪丽热巴", 22);
        Person p3 = new Person("王丽坤", 16);
        ArrayList<Person> list02 = new ArrayList<>();
        Collections.addAll(list02, p1, p2, p3);
        // [Person{name='王丽坤', age=18}, Person{name='迪丽热巴', age=22}, Person{name='王丽坤', age=16}]
        System.out.println(list02);
        // sort排序
        Collections.sort(list02);
        // [Person{name='王丽坤', age=16}, Person{name='王丽坤', age=18}, Person{name='迪丽热巴', age=22}]
        System.out.println(list02);


    }
}
