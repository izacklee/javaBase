package cn.itcast.day13.demo02;

import java.util.stream.Stream;

/*
    如果需要将流中的元素映射到另一个流中，可以使用map方法。
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    该接口需要一个 Function 函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
    Function中的抽象方法：
        R apply(T t);
*/
public class Demo03StreamMap {

    public static void main(String[] args) {
        // 获取一个String类型的流
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
        // 使用map方法，将流中的字符串元素映射（转换）成Integer类型的整数
        Stream<Integer> stream2 = stream.map(s -> Integer.parseInt(s));
        // 遍历stream2流
        stream2.forEach(i-> System.out.println(i));

    }

}
