package cn.itcast.day03.demo02;

import java.util.HashSet;

/*
HashSet存储自定义类型元素
    set集合保证元素唯一：
        存储的元素（String, Integer, Person...），必须重写hashCode和equals方法
    要求：
        同名同龄的人，视为同一个人，只能存储一次
*/
public class Demo01HashSet {

    public static void main(String[] args) {
        Person p1 = new Person("王丽坤",22);
        Person p2 = new Person("胡歌",28);
        Person p3 = new Person("王丽坤",22);

        // 重写hashCode与equals之前
        // 比较哈希值 不一致
        System.out.println(p1.hashCode()); // 100555887
        System.out.println(p3.hashCode()); // 1769597131
        // 再比较equals
        System.out.println(p1==p3); // false
        // 注意：这行代码重写hashCode与equals方法之后返回true，说明存在同一个人
        System.out.println(p1.equals(p3)); // false

        // 创建HashSet集合存储Person
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        /*
           未重写重写hashCode与equals方法返回：
            [Person{name='胡歌', age=28}, Person{name='王丽坤', age=22}, Person{name='王丽坤', age=22}]
           重写hashCode与equals方法后返回：
            [Person{name='胡歌', age=28}, Person{name='王丽坤', age=22}]
        */
        System.out.println(set);
    }
}
