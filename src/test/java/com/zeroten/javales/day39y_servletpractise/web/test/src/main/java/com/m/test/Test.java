package com.m.test;

// 解释为何要做IOC控制反转（调用方法从容器获取）
public class Test {
    public static void main(String[] args) {
        // 耦合
//        A a = new A();
//        a.test();

        // 解耦
        Ioc ioc = new Ioc();
        A a = ioc.getA();
        a.test();
    }
}

// Ioc容器：控制反转
class Ioc {
    A a = new A();
    B b = new B();
    C c = new C();
    A getA() {
        a.setB(b);
        b.setC(c);
        return a;
    }
}

class A {
    private B b;  // 解耦
    // 耦合：你中有我，我中有你，只要依赖中有new的就算是耦合
//    B b = new B(); // 耦合度太高（依赖注入和控制反转是什么关系）
    void test() {
        System.out.println("A调用");
        b.test();
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
class B {
    private C c;
//    C c = new C();
    void test(){
        System.out.println("B调用");
        c.test();
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
class C {
    void test() {
        System.out.println("C调用");
    }
}
