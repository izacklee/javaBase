package cn.itcast.day12.demo04;

import java.util.function.Consumer;

/*
    java.util.function.Consumer<T>：接口的默认方法andThen
    作用：需要两个Consumer接口，可以把两个接口组合到一起，再对数据进行消费

    例如：
        Consumer<String> con1
        Consumer<String> con2
        String s = "hello";
        con1.accept(s);
        con1.accept(s);
        连接两个Consumer接口 再进行消费
        con1.andThen(con2).accept(s); 谁写前边谁先消费
*/
public class Demo01AndThen {

    public static void main(String[] args) {
        // 使用Lambda方式，调用consumer方法
        String str = "Hello";
        consumer(str, s->System.out.println(s.toUpperCase()),
                s-> System.out.println(s.toLowerCase()));
    }

    // 定义一个方法，方法的参数传字符串，和两个Consumer接口
    public static void consumer(String s, Consumer<String> con1, Consumer<String> con2) {
        /*con1.accept(s);
        con2.accept(s);*/
        // 使用andThen写法 连在一起消费
        con1.andThen(con2).accept(s);
    }

}
