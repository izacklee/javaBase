package cn.itcast.day13.demo02;

import java.util.function.Consumer;
import java.util.stream.Stream;

/*
    Stream流中的常用方法：forEach
    void forEach(Consumer<? super T> action);
    该方法接收一个 Consumer 接口函数，会将每一个流元素交给该函数进行处理。
    Consumer接口是一个消费型的函数式接口，可以传递Lambda表达式，消费数据

    简单记：
        forEach方法，用来遍历流中的数据
        是一个终结方法，遍历之后就不能继续调用Stream流中的其他方法
*/
public class Demo01StreamForEach {

    public static void main(String[] args) {
        // 获取一个Stream
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");
        // forEach方法参数传递Consumer匿名内部类方式，输出字符串
        /*stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        // forEach方法参数传递Lambda表达式
        // 注意：想执行此行代码，上面的forEach代码必须注释，否则报：stream has already been operated upon or closed
        // 原因：forEach是终结方法，遍历之后不能再继续调用Stream流的方法（不支持链式编程（调用））
        stream.forEach(s-> System.out.println(s));

    }

}
