package cn.itcast.day03.demo01;

import java.util.LinkedList;

/*
java.util.linkedList集合 implements List接口
    linkedList集合的特点：
        1.底层是一个链表结构：查询慢，增删快
        2.里边含有大量操作首尾的方法：
         注意：使用linkedList集合特有的方法，不能使用多态。因为只有linkedList实现类本身有这些方法，它的父类没有。
            public void addFirst(E e) :将指定元素插入此列表的开头。
            public void addLast(E e) :将指定元素添加到此列表的结尾。
            public void push(E e) :将元素推入此列表所表示的堆栈。

            public E getFirst() :返回此列表的第一个元素。
            public E getLast() :返回此列表的最后一个元素。

            public E removeFirst() :移除并返回此列表的第一个元素。
            public E removeLast() :移除并返回此列表的最后一个元素。
            public E pop() :从此列表所表示的堆栈处弹出一个元素。

            public boolean isEmpty() :如果列表不包含元素，则返回true。

*/
public class Demo02LinkedList {

    public static void main(String[] args) {
//        show01();
//        show02();
        show03();
    }

    /*
        public E removeFirst() :移除并返回此列表的第一个元素。
        public E removeLast() :移除并返回此列表的最后一个元素。
        public E pop() :从此列表所表示的堆栈处弹出一个元素。

       public boolean isEmpty() :如果列表不包含元素，则返回true。
    */
    private static void show03() {
        LinkedList<String> linked = commonMethod();

        // 移除集合的第一个元素
//        String rf = linked.removeFirst();
        String rf = linked.pop(); // 等效于removeFirst方法
        System.out.println(rf); // a
        System.out.println(linked); // [c, b]

        linked.clear(); // 清空集合元素 但集合还在 只是删除集合所有元素而已

        // isEmpty方法
        // 可以解决当集合为空时，还做一些集合元素获取或删除操作报：NoSuchElementException元素不存在异常
        if (!linked.isEmpty()) {
            // 移除集合的最后一个元素
            String rl = linked.removeLast();
            System.out.println(rl); // b
            System.out.println(linked); // [c]
        }
    }

    /*
        public E getFirst() :返回此列表的第一个元素。
        public E getLast() :返回此列表的最后一个元素。
    */
    private static void show02() {
        LinkedList<String> linked = commonMethod();

        // 获取集合的第一个元素
        String f = linked.getFirst();
        System.out.println(f); // a

        // 获取集合d的最后一个元素
        String l = linked.getLast();
        System.out.println(l); // b

    }
    /*
        public void addFirst(E e) :将指定元素插入此列表的开头。
        public void addLast(E e) :将指定元素添加到此列表的结尾。
        public void push(E e) :将元素推入此列表所表示的堆栈。
    */
    private static void show01() {
        LinkedList<String> linked = commonMethod();

        // 将指定元素插入此列表的开头
//        linked.addFirst("linked");
        linked.push("linked"); // 等效于addFirst方法
        System.out.println(linked); // [linked, a, c, b]

        // 将指定元素添加到此列表的结尾
        linked.addLast("end");
        System.out.println(linked); // [linked, a, c, b, end]
    }

    // 公共的方法
    private static LinkedList<String> commonMethod() {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("c");
        linked.add("b");
        System.out.println(linked); // [a, c, b]

        return linked;
    }
}
