package cn.itcast.day01.demo05;

/*
StringBuilder和String可以相互转换：
    String -> StringBuilder：使用StringBuilder的构造方法
         StringBuilder(String str)：构造生成一个字符串生成器，并初始化为指定的字符串内容。
    StringBuilder -> String：使用StringBuilder的toString方法
        public String toString()：将当前StringBuilder对象转换为String对象
*/
public class Demo03StringBuilder {

    public static void main(String[] args) {
        // String -> StringBuilder
        String str = "Hello";
        StringBuilder sb = new StringBuilder(str);
        sb.append("Java");
        System.out.println("sb：" + sb); // sb：HelloJava

        // StringBuilder -> String
        String str1 = sb.toString();
        System.out.println("str1：" + str1); // str1：HelloJava

    }

}
