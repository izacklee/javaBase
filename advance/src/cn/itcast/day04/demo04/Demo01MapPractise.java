package cn.itcast.day04.demo04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    练习：
        计算一个字符串中每个字符出现的次数

    分析：
        1.使用Scanner获取用户输入的字符串
        2.创建Map集合,key是字符串中的字符，value是字符的个数
        3.遍历字符串，获取每一个字符
        4.用获取到的字符，去Map集合判断key是否存在
            key存在：
                通过字符(key)，获取value（字符个数）
                value++
                put(key,value)把新的value存储到Map集合中
            key不存在：
                put(key,1)
        5.遍历Map集合，输出结果
*/
public class Demo01MapPractise {

    public static void main(String[] args) {
        // 获取用户输入的字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        char[] arr =  str.toCharArray();

        // 创建Map集合
        Map<Character,Integer> map = new HashMap<>();

        // 遍历字符串字符
        // 这也可用增强for写：for (char c : str.toCharArray()) {}
        for (int i = 0; i < arr.length; i++) {
            char key =arr[i];
            // 判断key是否已存在map集合中
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                value++;
                map.put(key,value); // 重新更新map集合对应key和value的数据
            } else {
                map.put(key,1); // key在map集合中不存在，默认给个1
            }
        }

        // 遍历输出集合元素
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }

    }

}
