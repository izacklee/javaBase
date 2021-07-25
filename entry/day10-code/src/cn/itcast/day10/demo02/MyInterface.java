package cn.itcast.day10.demo02;

public interface MyInterface {

    public default void method() {
        System.out.println("接口默认方法");
    }

    public static void methodStatic() {
        System.out.println("接口静态方法执行了");
    }
}
