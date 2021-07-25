package cn.itcast.day12.demo05;

import java.util.function.Function;

/*
    Function接口中的默认方法andThen：用来进行组合操作

    需求：
        把String类型的"123"，转换为Integer类型，把转换后的结果加10
        把增加之后的Integer类型的数据，转换为String类型

    分析：
        转换了两次
        第一次是把String类型的字符串转换为Integer类型
            所以我们可以使用Function<String,Integer> fun1
                Integer i = fun1.apply("123") + 10;
        第二次是把Integer类型转换为String
            所以我们可以使用Function<Integer,String> fun2
                String s = fun2.apply(i);
        我们可以使用andThen方法，把两次转换组合在一起使用
            String s = fun1.andThen(fun2).apply("123");
            先调用fun1，把字符串转换为Integer
            再调用fun2，把Integer转换为String
*/
public class Demo02FunctionAndThen {

    public static void main(String[] args) {
        // 使用Lambda表达式，调用change方法
        String str = "123";
        String s = change(str,t->Integer.parseInt(t)+10,t->t+"");
        System.out.println(s);
    }

    /*
        定义一个方法
        返回值类型：String
        参数传递一个字符串，和两个Function接口，fun1泛型<String,Integer>，fun2泛型<Integer,String>
     */
    public static String change(String s, Function<String,Integer> fun1, Function<Integer,String> fun2) {
//        Integer i = fun1.apply(s);
//        String ns = fun2.apply(i);
//        return ns;

        // 使用andThen把两次转换组合在一起使用
        return fun1.andThen(fun2).apply(s);
    }

}
