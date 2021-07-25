package cn.itcast.day12.demo04;

import java.util.function.Predicate;

/*
    需求：判断一个字符串长度是否大于5
        大于，返回false
        不大于，返回true
    所以我们可以使用取反!的符号，对结果进行取反

    Predicate接口中有一个方法negate，表示取反的意思
    default Predicate<T> negate() {
           return (t) ‐> !test(t);
    }
*/
public class Demo06PredicateNegate {

    public static void main(String[] args) {
        String str = "fdsasds";
        /*
            1.判断字符串的长度是否大于5
        */
        boolean b = checkString(str,s->s.length() > 5);
        System.out.println(b);
    }
    /*
        定义一个方法
        方法的参数传递一个字符串，和两个Predicate接口，泛型给String
    */
    public static boolean checkString(String s, Predicate<String> pre) {
//        return !pre.test(s);
        // 使用negate写法
        return pre.negate().test(s); // 等价于return !pre.test(s);
    }

}
