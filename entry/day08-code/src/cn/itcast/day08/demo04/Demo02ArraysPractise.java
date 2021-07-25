package cn.itcast.day08.demo04;

import java.util.Arrays;

/*
题目：
请使用Arrays相关API，将一个随机字符串中的所有字符升序排列，并倒序打印。
*/
public class Demo02ArraysPractise {
    public static void main(String[] args) {
        // 随便定义一个字符串
        String str = "1uehyw8293-[[112121fehwhwiw";

        // 如何进行升序排序: sort
        // 必须是一个数组，才能使用Arrays.sort方法
        // String --> 数组，用toCharArray()
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        // 倒序遍历
        for (int i = charArray.length - 1; i > 0; i--) {
            System.out.println(charArray[i]);
        }
    }
}
