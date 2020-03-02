package com.zeroten.javales.day07y_reflectannotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@E(value="")
@E()
@E()
public class Demo01Annotation {

    public static void main(String[] args) {
        C c = new C() {
            @Override
            public void test1() {
                System.out.println("覆盖重写 test1方法");
            }
        };
        c.test1(); // 覆盖重写 test1方法
        c.test3(); // test3
    }
}

@Repeatable(F.class)
@interface E {
    String value() default "";
}
@Retention(RetentionPolicy.RUNTIME)
@interface F {
    E[] value();
}

class D<E> {
    @SuppressWarnings("unchecked")
    void test1(E ... e) {

    }
    @SafeVarargs // java 7 忽略参数为泛型变量的方法或构造产生的警告  只针对与final的情况下才能用
    final void test2(E ... e) {

    }
}
