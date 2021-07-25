package cn.itcast.day12.demo04;

import java.util.function.Predicate;

/*
    需求：判断一个字符串，有两个判断的条件
        1.判断字符串的长度是否大于5
        2.判断字符串中是否包含a
    满足一个条件即可，我们就可以使用||运算符连接两个条件

    Predicate接口中有一个方法or，表示或者关系，也可以用于连接两个判断条件
    default Predicate<T> or(Predicate<? super T> other) {
           Objects.requireNonNull(other);
           return (t) ‐> test(t) or other.test(t);
    }
    方法内部的两个判断条件，也是使用||运算符连接起来的
*/
public class Demo05PredicateOr {

    public static void main(String[] args) {
        String str = "fdsa";
        /*
            1.判断字符串的长度是否大于5
            2.判断字符串中是否包含a
        */
        boolean b = checkString(str,s->s.length() > 5, s->s.contains("a"));
        System.out.println(b);
    }
    /*
        定义一个方法
        方法的参数传递一个字符串，和两个Predicate接口，泛型给String
    */
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
//        return pre1.test(s) || pre2.test(s);
        // 使用or写法
        return pre1.or(pre2).test(s); // 等价于return pre1.test(s) || pre2.test(s);
    }

}
