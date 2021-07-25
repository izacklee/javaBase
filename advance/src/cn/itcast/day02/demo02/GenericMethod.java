package cn.itcast.day02.demo02;

public class GenericMethod {
    // 定义一个含有泛型的方法
    public <M> void method1(M m) {
        System.out.println(m);
    }

    // 定义一个含有泛型的静态方法
    public static <T> void methodStatic(T t) {
        System.out.println(t);
    }
}
