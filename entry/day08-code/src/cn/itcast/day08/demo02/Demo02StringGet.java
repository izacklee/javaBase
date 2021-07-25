package cn.itcast.day08.demo02;

/*
String当中与获取相关的常用方法有：
    public int length()：获取字符串当中含有的字符个数，拿到字符串长度。
    public String concat(String str)：将当前字符串和参数字符串拼接成为返回值新的字符串。
    public char charAt(int index)：获取指定索引位置的单个字符。（索引从0开始）
    public int indexOf(String str)：查找参数字符串在本字符串中首次出现的索引位置，如果没有则返回-1值。
*/
public class Demo02StringGet {
    public static void main(String[] args) {
        // 获取字符串的长度
        String str = "hsduq8782nnej3q012121dd";
        int len = str.length();
        System.out.println("字符串的长度是：" + len);
        System.out.println("===============");

        // 拼接字符串
        String str1 = "Hello";
        String str2 = "World";
        String strResult = str1.concat(str2);
        System.out.println(str1); // Hello，原封不动
        System.out.println(str2); // World，原封不动
        System.out.println("字符串拼接的结果：" + strResult); // HelloWorld，新字符串

        // 获取索引位置的单个字符
        String str3 = "Java";
        char zifu = str3.charAt(2);
        System.out.println("获取到的字符是：" + zifu); // v

        // 查找参数字符串首次出现的位置
        String str4 = "Java Hello";
        int index = str4.indexOf("H");
        System.out.println("字符串首次出现的位置：" + index); // 5
        System.out.println(str4.indexOf("wo")); // -1 ，没有返回-1

    }
}
