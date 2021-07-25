package cn.itcast.day12.demo03;

import java.util.function.Consumer;

/*
     java.util.function.Consumer<T> 接口则正好与Supplier接口相反，
     它不是生产一个数据，而是消费一个数据， 其数据类型由泛型决定。
     Consumer接口中包含抽象方法void accept(T t)，意味消费一个指定泛型的数据。

     Consumer接口是一个消费型接口，泛型执行什么类型，就可以使用accept方法消费什么类型数据
     至于具体怎么消费（使用），需要自定义（输出，计算...）
*/
public class Demo04Consumer {

    public static void main(String[] args) {
        // 使用Lambda表达式，调用toConsumer方法
        String name = "王丽坤";
        // 消费方式：把字符串反转输出
        // java.lang.StringBuffer：线程安全的可变字符序列。一个类似于 String 的字符串缓冲区，但不能修改。
        toConsumer(name,n->System.out.println(new StringBuilder(name).reverse().toString()));
    }

    /*
        定义一个方法
        方法的参数传递一个字符串（姓名）和Consumer接口，泛型指定为String
        可以使用Consumer接口消费字符串的姓名
     */
    public static void toConsumer(String name, Consumer<String> con) {
        con.accept(name);
    }

}
