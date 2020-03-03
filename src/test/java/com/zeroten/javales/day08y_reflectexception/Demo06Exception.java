package com.zeroten.javales.day08y_reflectexception;

public class Demo06Exception {

    public static void main(String[] args) /* throws ArithmeticException */ {
        // 处理异常 try catch
        // 手动抛出异常 throw
        // 自动抛出异常 throws
        A a = new A();
        a.test();

        // 看业务：决定什么时候捕，什么时候抛


        // 手动抛异常
        int age = 1000;
        if (age < -1 || age > 126) {
//            throw new RuntimeException("age is illegal");
            throw new AgeInvalidException("age is invalid");
        }
    }

}

class A {
    void test() {
        try {
            // 捕获了，就算处理完毕了，后续调用者无需再关注
            Class.forName(""); // 必须被处理的异常：怎么处理？捕获或自动抛出
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("算数异常了");
        }

    }
}
