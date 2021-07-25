package cn.itcast.day12.demo04;

import java.util.function.Predicate;

/*
    逻辑表达式：可以连接多个判断条件
    &&：与(也叫短路与)运算符，有false则false
    ||：或(也叫短路或)运算符，有true则true
    !：非（取反）运算符，非真则假，非假则真

    需求：判断一个字符串，有两个判断的条件
        1.判断字符串的长度是否大于5
        2.判断字符串中是否包含a
    两个条件必须同时满足，我们就可以使用&&运算符连接两个条件

    Predicate接口中有一个方法and，表示并且关系，也可以用于连接两个判断条件
    default Predicate<T> and(Predicate<? super T> other) {
           Objects.requireNonNull(other);
           return (t) ‐> test(t) && other.test(t);
    }
    方法内部的两个判断条件，也是使用&&运算符连接起来的
*/
public class Demo04PredicateAnd {

    public static void main(String[] args) {
        String str = "fdshhgas";
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
//        return pre1.test(s) && pre2.test(s);
        // 使用and写法
        return pre1.and(pre2).test(s); // 等价于return pre1.test(s) && pre2.test(s);
    }
}
