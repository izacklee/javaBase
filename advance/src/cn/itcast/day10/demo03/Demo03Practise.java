package cn.itcast.day10.demo03;

import java.io.*;
import java.util.HashMap;

/*
    练习：
        对文本的内容进行排序
        按照（1，2，3...）顺序排序
    分析：
        1.创建一个HashMap集合对象，可以：存储每行文本的序号（1，2，3，...）；value:存储每行的文本
        2.创建字符缓冲输入流对象，构造方法中传递字符输入流
        3.创建字符输出流缓冲对象，构造方法中传递字符输出流
        4.使用字符缓冲输入流的readLine方法，逐行读取文本
        5.对读取到的文本进行切割，获取行中的序列号和内容
        6.把切割好的系列号和内容存入到HashMap集合中（key序号是有序的，会自动排序1，2，3，...）
        7.遍历HashMap集合，获取每一个键值对
        8.把每一个键值对拼接成一个文本行
        9.把拼接好的文本行，使用字符缓冲输出流的write方法，写入到文件中
        10.释放资源

*/
public class Demo03Practise {

    public static void main(String[] args) throws IOException {
        // 1.创建一个HashMap集合对象，可以：存储每行文本的序号（1，2，3，...）；value:存储每行的文本
        HashMap<String,String> map = new HashMap<>();
        // 2.创建字符缓冲输入流对象，构造方法中传递字符输入流
        BufferedReader br = new BufferedReader(new FileReader("advance/src/cn/itcast/day10/test/in.txt"));
        // 3.创建字符输出流缓冲对象，构造方法中传递字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("advance/src/cn/itcast/day10/test/newin.txt"));
        // 4.使用字符缓冲输入流的readLine方法，逐行读取文本
        String line;
        while ((line = br.readLine()) !=null ) {
            // 5.对读取到的文本进行切割，获取行中的序列号和内容
            String[] split = line.split("\\.");
            // 6.把切割好的系列号和内容存入到HashMap集合中（key序号是有序的，会自动排序1，2，3，...）
            map.put(split[0],split[1]);
        }
        // 7.遍历HashMap集合，获取每一个键值对
        for (String key : map.keySet()) {
            String value = map.get(key);
            // 9.把拼接好的文本行，使用字符缓冲输出流的write方法，写入到文件中
            bw.write(key + "." +value);
            bw.newLine(); // 换行
        }
        // 10.资源释放
        bw.close();
        br.close();
    }

}
