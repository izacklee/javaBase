package cn.itcast.day01.demo01;

import java.util.Objects;

public class Demo03Objects {

    public static void main(String[] args) {
        String str1 = null;
        String str2 = "abc";
        // 错误写法！ null不能调用equals方法，会抛出NullPointerException空指针异常
//        System.out.println(str1.equals(str2));

        // Objects类的equals方法增加了健壮性的判断，更为安全
        /*
            源码：
            public static boolean equals(Object a, Object b) {
                return (a == b) || (a != null && a.equals(b));
            }
        */
        System.out.println(Objects.equals(str1, str2)); // 写法正确！ 返回false
    }

}
