package cn.itcast.day04.demo03;

/*
使用方法的时候，注意事项：
    1.方法应该定义在类当中，但是不能在方法当中在定义方法。不能嵌套。
    2.方法定义的前后顺序无所谓。
    3.方法定义之后不会执行的。如果希望执行，一定要调用：单独调用、打印调用、赋值调用。
    4.如果方法有返回值，必须“return 返回值;”，不能没有。
    5.return后面返回的数据类型，必须和方法返回的数据类型对应起来。
    6.对于一个void没有返回值的方法，不能return后面的返回值，只能return自己。
    7.对于void方法的最后一个return可以省略不写。
    8.一个方法当中可以有多个return语句，但是必须保证同时只有一个会被执行，两个return不能连写。
*/

public class Demo05MethodNotice {
    public static int method() {
        return 10;
    }

    public static void method1() {
//        return 10;  // 错误写法！void方法没有返回值，return后面不能写返回值
        return; // 正确写法。没有返回值，只能结束方法的执行而已。
    }

    public static void method2() {
        System.out.println("AAA");
        System.out.println("BBB");
//        return;  // 最后一行的return可省略不写。
    }
}
