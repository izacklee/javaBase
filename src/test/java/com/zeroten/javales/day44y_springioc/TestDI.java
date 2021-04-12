package com.zeroten.javales.day44y_springioc;

/**
 * 依赖注入案例
 */
public class TestDI {
    public static void main(String[] args) {

    }

}

class A {
    B b = new B(); // A依赖B执行，所以把B注入A：依赖注入
    public void test() {
        b.test();
    }
}

class B {
    public void test() {

    }
}
