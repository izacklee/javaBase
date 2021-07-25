package cn.itcast.day08.demo02;

/*
==是进行对象的地址比较，如果确实需要字符串内容比较，可以使用两个方法：
     public boolean equals(Object obj)：参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true；否则返回false。
     备注：任何对象都能用Object进行接收。

注意事项：
    1.任何对象都能用Object接收。
    2.equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样。
    3.如果比较双方一个常量一个变量，推荐把常量写在前面。
    推荐："abc".equals(str); 不推荐：str.equals("abc");

public boolean equalsIgnoreCase(String str)：忽略大小写，进行内容比较。

*/

public class Demo01StringEquals {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);

        System.out.println(str1.equals(str2)); // true
        System.out.println(str2.equals(str3)); // true

        System.out.println("=================");

        String str4 = null;
        // System.out.println(str4.equals("abc")); // 不推荐，报错！NullPointerException
        System.out.println("abc".equals(str4));  // false  推荐
        System.out.println("===============");

        String str5 = "hello";
        System.out.println(str2.equals(str5)); // false 因：equals 区分大小写
        System.out.println(str2.equalsIgnoreCase(str5)); // true 因：equalsIgnoreCase 忽略大小写
        // 注意：只有英文区分大小写，其他无效。
        System.out.println("abc一123".equalsIgnoreCase("abc壹123")); // false
    }
}
