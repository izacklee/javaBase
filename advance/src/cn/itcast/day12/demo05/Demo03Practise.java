package cn.itcast.day12.demo05;

import java.util.function.Function;

/*
    练习：自定义函数拼接模型

    题目：请使用Function进行函数模型拼接，按照顺序需要执行的多个函数操作为：
        String str = "赵丽颖,20";

    分析：
        1.将字符串截取数字年龄部分，得到字符串
            Function<String,String> "赵丽颖,20"->"20"
        2.将上一步的字符串转换为int类型数字
            Function<String,Integer> "20"->20
        3.将上一步int数字累加100，得到结果int数字
            Function<Integer,Integer> 20->20
*/
public class Demo03Practise {

    public static void main(String[] args) {
        // 使用Lambda表达式，调用change方法
        String str = "赵丽颖,20";
        int in = change(str,s->
            // 1.将字符串截取数字年龄部分，得到字符串
            s.split(",")[1]
        ,s->
           // 2.将上一步的字符串转换为int类型数字
           Integer.parseInt(s)
        ,i->
           // 3.将上一步int数字累加100，得到结果int数字
           i + 100
        );
        System.out.println(in);
    }

    /*
        定义方法三要素
            方法名称： change
            返回值类型：int
            参数列表：String s, Function<String,String> fun1, Function<String,Integer> fun2,
                    Function<Integer,Integer> fun3
    */
    public static int change(String s, Function<String,String> fun1, Function<String,Integer> fun2,
                              Function<Integer,Integer> fun3) {
        // 使用andThen方法，将三个转换组合到一起
        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }

}
