package cn.itcast.day13.demo02;

import java.util.stream.Stream;

/*
    Stream流中的常用方法filter：用于对Stream流中的数据进行过滤
    Stream<T> filter(Predicate<? super T> predicate);
    filter方法的参数Predicate是一个函数式接口，所以可以传递Lambda表达式，对数据进行过滤
    Predicate中的抽象方法：
        boolean test(T t)
*/
public class Demo02StreamFilter {

    public static void main(String[] args) {
        // 创建一个stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "赵敏", "张无忌", "周芷若");
        // 使用filter方法过滤，只要姓名为张开头，长度为3的人
        stream.filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(i-> System.out.println(i));

        /*
            错误写法！java.lang.IllegalStateException: stream has already been operated upon or closed
            Stream流属于管道流，只能被消费（使用）一次
            第一个Stream流使用完毕之后，数据就会传到下一个Stream上
            而这时第一个流已经使用完毕，就会关闭了
            所以第一个流就不能再调用其他方法了
        */
//        stream.forEach(i-> System.out.println(i));

    }

}
