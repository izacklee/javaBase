package cn.itcast.day02.demo02;

import java.util.ArrayList;
import java.util.Iterator;

/*
泛型的通配符：
    ?： 代表任意的数据类型
使用方式：
    不能创建对象使用，只能做方法的参数传递

Java泛型中的标记符含义：
 E - Element (在集合中使用，因为集合中存放的是元素)
 T - Type（Java 类）
 K - Key（键）
 V - Value（值）
 N - Number（数值类型）
 ？ -  表示不确定的java类型
 S、U、V  - 2nd、3rd、4th types
 Object跟这些标记符代表的java类型有啥区别呢？
 Object是所有类的根类，任何类的对象都可以设置给该Object引用变量，使用的时候可能需要类型强制转换，
 但是用使用了泛型T、E等这些标识符后，在实际用之前类型就已经确定了，不需要再进行类型强制转换。
*/
public class Demo05Generic {

    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("b");

//        ArrayList<?> list03 = new ArrayList<?>(); // 错误写法！创建集合对象的时候不能使用泛型

        printArray(list01);
        printArray(list02);
    }

    /*
        定义一个方法遍历所有类型的ArrayList集合
        这时候我们不知道ArrayList传递过来的是什么泛型，可以使用泛型的通配符“?”来接收

        注意：泛型是没有继承的概念的
    */

    public static void printArray(ArrayList<?> list) {
        // 创建迭代器的对象
        Iterator it = list.iterator();
        // 判断集合是否还有下一个元素
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }

//         for 循环 不灵活 可改用增强for循环
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }

}
