package cn.itcast.day01.demo05;

/*
java.lang.StringBuilder类：
字符串缓冲区，可以提高字符串的操作效率（看成一个长度可以变化的字符串）
底层是一个数组，但没有被final修饰，可以改变长度
长度默认16个字节，超出会自动扩容

构造方法：
    public StringBuilder()：构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符。
    public StringBuilder(String str)：构造一个字符串生成器，并初始化为指定的字符串内容。
*/
public class Demo01StringBuilder {
    public static void main(String[] args) {
        StringBuilder bu1 = new StringBuilder();
        System.out.println("bu1：" + bu1); // bu1：

        StringBuilder bu2 = new StringBuilder("abc");
        System.out.println("bu2：" + bu2); // bu2：abc
    }
}
