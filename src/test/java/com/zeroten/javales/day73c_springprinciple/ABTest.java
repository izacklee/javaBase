package com.zeroten.javales.day73c_springprinciple;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class ABTest {

    public static void main(String[] args) {

        A a = new A();

        B b = new B();

        Map<String, Object> map = new HashMap<>();
        map.put("a", a);

        // 通过这个方式可以解决属性、单例的循环依赖
        // 无法解决构造函数的循环依赖，会形成死节（比如，创建A，发现依赖于B，创建B，发现又依赖于A）
        if (map.containsKey("a")) {

            b.setA((A) map.get("a"));
        }

        a.setB(b);
    }

    @Data
    static class A {

        B b;

        // 不支持这种
//        public A(B b) {
//
//            this.b = b;
//
//            System.out.println("this is A");
//        }

        public A() {

            System.out.println("this is A");
        }

    }

    @Data
    static class B {

        A a;

        // 不支持这种
//        public B(A a) {
//
//            this.a = a;
//
//            System.out.println("this is B");
//        }

        public B() {

            System.out.println("this is B");
        }
    }
}
