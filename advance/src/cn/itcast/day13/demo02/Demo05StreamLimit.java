package cn.itcast.day13.demo02;

import java.util.stream.Stream;

/*
    Stream流中常用的方法limit：用于截取流中的元素
    limit方法可以对流进行截取，只取用前n个。方法签名：
    Stream<T> limit(long maxSize);
        参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作。
    limit方法是一个延迟方法，只是对流中的元素进行截取，返回的是一个新的流，所以可以继续调用Stream流的方法
*/
public class Demo05StreamLimit {

    public static void main(String[] args) {
        // 获取一个Stream流
        String[] arr = {"胡歌", "王丽坤", "江疏影", "迪丽热巴"};
        Stream<String> stream = Stream.of(arr);

        // 使用limit方法，截取流中的元素，获取前3个
        Stream<String> stream2 = stream.limit(3);
        // 遍历stream2流
        /*
            胡歌
            王丽坤
            江疏影
        */
        stream2.forEach(name-> System.out.println(name));
    }

}
