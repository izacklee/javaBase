package cn.itcast.day13.demo02;

import java.util.stream.Stream;

/*
    Stream流中的常用方法concat：用于把流组合到一起
    如果有两个流，希望合并成为一个流，那么可以使用Stream接口的静态方法concat
    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
*/
public class Demo07StreamConcat {

    public static void main(String[] args) {
        // 获取一个Stream流
        String[] arr = {"胡歌", "王丽坤", "江疏影", "迪丽热巴"};
        Stream<String> stream1 = Stream.of(arr);

        // 再获取一个Stream流
        Stream<String> stream2 = Stream.of("张三丰", "张翠山", "赵敏", "张无忌", "周芷若");

        // 使用concat方法，把stream1流和stream2流组合到一起
        Stream<String> stream3 = Stream.concat(stream1, stream2);
        // 遍历stream3流
        stream3.forEach(name-> System.out.println(name));
    }

}
