package cn.itcast.day13.demo02;

import java.util.stream.Stream;

/*
    Stream流中常用的方法skip：用于跳过元素
    如果希望跳过前几个元素，可以使用skip方法获取一个截取之后的新流：
    Stream<T> skip(long n);
        如果流的当前长度大于n，则跳过前n个;否则将会得到一个长度为0的空流。
*/
public class Demo06StreamSkip {

    public static void main(String[] args) {
        // 获取一个Stream流
        String[] arr = {"胡歌", "王丽坤", "江疏影", "迪丽热巴"};
        Stream<String> stream = Stream.of(arr);

        // 使用skip方法跳过前3个元素
        Stream<String> stream2 = stream.skip(3);
        // 遍历stream2流
        stream2.forEach(name-> System.out.println(name)); // 迪丽热巴

    }

}
