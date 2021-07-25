package cn.itcast.day12.demo04;

import java.util.function.Predicate;

/*
    java.util.function.Predicate<T> 接口
    作用：对某种类型的数据进行判断，从而得到一个boolean值结果。

    Predicate接口中包含一个抽象方法：
        boolean test(T t)：用来指定数据类型进行判断的方法
            结果：
                符合条件，返回true
                不符合条件，返回false
*/
public class Demo03Predicate {

    public static void main(String[] args) {
        // 使用Lambda表达式，调用method方法，判断字符串长度是否大于5
        String str = "hgfssaa";
        boolean bool = checkString(str,s->s.length() > 5);
        System.out.println(bool);

    }
    /*
        定义一个方法
        参数传递一个字符串，和Predicate接口，泛型给String
        使用Predicate中的test方法对字符串进行判断，并把判断结果返回
     */
    public static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
    }

}
