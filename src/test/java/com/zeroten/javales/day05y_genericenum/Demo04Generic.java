package com.zeroten.javales.day05y_genericenum;

// 泛型类的定义和使用
public class Demo04Generic<T> {

    public static void main(String[] args) {
        Demo04Generic<String> dg = new Demo04Generic<String>();
        dg.test("", "");
    }

    // 返回值是泛型
    public <A> A test(T t, A a) {
        return a;
    }
}
