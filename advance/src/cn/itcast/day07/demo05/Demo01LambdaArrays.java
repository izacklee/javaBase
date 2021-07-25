package cn.itcast.day07.demo05;

import java.util.Arrays;
import java.util.Comparator;

/*
    Lambda表达式有参数有返回值的练习
    需求：
        使用数组存储多个Person对象
        对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
*/
public class Demo01LambdaArrays {

    public static void main(String[] args) {
        // 创建Person对象数组
        Person[] p = {
                new Person("王丽坤",18),
                new Person("胡歌",28),
                new Person("李易峰",26)
        };
        // 使用Arrays的sort对年龄升序排序
        /*Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        // 使用Lambda表达式简化代码 对年龄降序排序
        Arrays.sort(p,(o1,o2) -> o2.getAge() - o1.getAge());

        // 循环遍历输出
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }

    }

}
