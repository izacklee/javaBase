package cn.itcast.day02.demo02;

/*
    创建集合对象，不使用泛型
        好处：集合不使用泛型，默认的类型就是Object类型，可以存储任意数据的类型。
        弊端：不安全，会发生异常
    创建集合对象，使用泛型
        好处：
            1.避免了类型转换的麻烦，存储的是什么类型，取出的就是什么类型
            2.把运行期间异常（代码运行之后会抛出异常），提升到了编译器（写代码的时候会报错）
        弊端：
            泛型是什么类型，就只能存储什么类型的数据
*/

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01Element {

    public static void main(String[] args) {
//        show01();
        show02();
    }

    // 使用泛型
    private static void show02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("李易峰");
        list.add("胡歌");
//        list.add(1); // 错误！编译的时候就报错了
        Iterator it = list.iterator();
        for (String s : list) {
            System.out.println(s);
        }
    }

    // 不使用泛型
    private static void show01() {
        ArrayList list = new ArrayList();
        // 添加字符串类型数据
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("王丽坤");

        // 添加整型或双精度浮点数类型数据
        list.add(1);
        list.add(3.14);

        // 使用迭代器遍历集合
        Iterator it = list.iterator();
        // 使用while循环遍历集合
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
//
//            // 想要使用Stringt特有的方法length获取字符串长度，不能直接使用，需要向下转型。
//            String s = (String)o;  // 不安全！当遇到非字符串的情况下就会抛出ClassCastException异常
//            int len = s.length();
//            System.out.println(len);
        }
    }

}
