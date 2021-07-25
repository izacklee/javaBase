package cn.itcast.day08.demo02;

/*
String当中与转换相关的常用方法有：
public char[] toCharArray()：将当前字符串拆分成字符数组作为返回值。
public byte[] getBytes()： 获得当前字符串底层的字节数组。
public String replace(CharSequence oldString, CharSequence newString)：
将所有出现的老字符串，替换成新字符串，并返回替换之后的新字符串。
*/
public class Demo04StringConvert {
    public static void main(String[] args) {
        // 将字符串拆分成数组
        char[] charArray = "Hello".toCharArray();
        System.out.println("字符数组：" + charArray[0]); // H
        System.out.println(charArray.length); // 5

        System.out.println("============");

        // 字符串转成字节数组
        byte[] byteArray = "abc".getBytes();
        for (int i = 0; i < byteArray.length; i++) {
            byte num = byteArray[i];
            System.out.println(num);
        }

        System.out.println("============");

        // 字符串内容替换
        String str = "How are you?";
        String resultStr = str.replace("o","*");
        System.out.println(str); // How are you? 原来的不变，所以替换后必须有返回值接住
        System.out.println(resultStr); // H*w are y*u?

        String lang1 = "会不会玩儿呀！你大爷的！";
        String lang2 = lang1.replace("你大爷", "***");
        System.out.println(lang2); // 会不会玩儿呀！***的！
    }
}
