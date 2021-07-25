package cn.itcast.day12.demo03;

import java.util.function.Supplier;

/*
    常用函数式接口：
    java.util.function.Supplier<T> 接口仅包含一个无参的方法: T get() 。用来获取一个泛型参数指定类型的对象数据。

    Supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会产生什么类型数据
*/
public class Demo02Supplier {

    public static void main(String[] args) {
        // 调用getString方法 用匿名内部类的方式
        String str = getString(new Supplier<String>() {
            @Override
            public String get() {
                // 生产一个字符串，并返回
                return "胡歌";
            }
        });
        System.out.println(str);

        // 用Lambda表达式优化
        String str1 = getString(()->"王丽坤");
        System.out.println(str1);
    }

    //定义一个方法，方法的参数传递Supplier<T>接口，泛型执行String，get方法就会返回一个String
    public static String getString(Supplier<String> sup) {
        return sup.get();
    }


}
