package com.zeroten.javales.day44y_springioc;

/**
 * 控制反转案例
 */
public class TestIoC {

    public static void main(String[] args) {

        // 容器
        C c = new C();
        D d = new D();
        c.setD(d); // IOC
//        c.test();

    }

}

class C {
    D d;
    public void test() {
//        d.test();
    }
    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }
}

class D {
    public void test() {

    }
}
