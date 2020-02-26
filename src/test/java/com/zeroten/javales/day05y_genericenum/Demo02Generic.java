package com.zeroten.javales.day05y_genericenum;

import java.util.HashMap;
import java.util.Map;

// 泛型的定义和使用
public class Demo02Generic {

    public static void main(String[] args) {
        // 泛型，类的使用
        MyMap<String,Object> m = new MyHashMap<String, Object>();
    }

}
// 泛型接口
interface MyMap<P,E> {
    public void put(P p, E e);
    public E get(P p);
}

// 泛型类
class MyHashMap<P,E> implements MyMap<P,E> {
    private Map m = new HashMap();

    @Override
    public void put(P p, E e) {
        m.put(p, e);
    }

    @Override
    public E get(P e) {
        return (E) m.get(e);
    }
}