package cn.itcast.day07.demo04;

/*
ArrayList当中常用的方法有：
    public boolean add(E e)：向集合当中添加元素，参数的类型和泛类型一致。返回值类型代表是否添加成功。
    备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值类型可以不用。
    但是对于其他集合（今后学习）来说，add添加动作不一定成功。
    public E get(int index)：从集合当中获取的元素，参数是索引值，返回值就是对应索引的元素。
    public E remove(int index)：从集合当中删除元素，参数是索引值，返回值就是被删除的元素
    public int size()：获取集合的尺寸长度，返回值是集合中包含的元素个数。
*/

import java.util.ArrayList;

public class Demo03ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // 向集合中添加元素
        boolean success = list.add("柳岩");
        System.out.println(list); //[柳岩]
        System.out.println("添加的动作是否成功：" + success);

        list.add("王丽坤");
        list.add("范冰冰");
        System.out.println(list);

        // 获取集合中的元素
        String name = list.get(1); // 王丽坤
        System.out.println("第1号元素是：" + name);

        // 删除集合中的元素
        String whoRemove = list.remove(2);
        System.out.println("删除集合中的第3号元素：" + whoRemove);
        System.out.println(list);

        // 获取集合的尺寸长度
        int len = list.size();
        System.out.println("集合的尺寸长度是：" + len);

    }
}
