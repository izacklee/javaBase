package com.zeroten.javales.day05y_genericenum;

import java.util.*;

// 为什么会有泛型，以及4大集合泛型的使用
public class Demo01Generic {
    // 必须掌握！~！！！
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(1);
        l.add("");
        l.add(new Date());

        for(int i=0; i < l.size(); i++) {
            // 下一步没法处理了，需要一个个判断，然后进行强转
//            int in = (int) l.get(i);
            // java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
//            System.out.println(in);
//            System.out.println(i);
        }
        // 加上泛型，当前集合只能添加泛型规定的类型
//        List<String> l2 = new ArrayList<String>();
//        l2.add("Zack");

        // 泛型为类名时，可添加该类及其子类对象
        List<A> l2 = new ArrayList<A>();
        l2.add(new A());
        l2.add(new B());
        A a = l2.get(0); // 多态 父类引用指向子类对象
        if(a instanceof B) {
            B b = (B)a;
        }

        // 如果是基本数据类型，只能使用该类型对应的包装类
        List<Number> l3 = new ArrayList<Number>();
        l3.add(3.1415926);
        for(Number n : l3) {

        }
        // 泛型为接口时，可添加该接口的实现类对象
//        List<IA> l2 = new ArrayList<IA>();
//        l2.add(new IB());
//        l2.add(new IC());

        LinkedList<String> ll2 = new LinkedList<String>();
        ll2.add("A");
        for(String s : ll2) {

        }

        Set<String> s = new HashSet<String>();
        s.add("S");
        for(String s2 : s) {

        }

        Map<String,Object> m = new HashMap<String,Object>();
        m.put("a",1);
        m.get("a");
        // m.entrySet() 将Map集合转换为Set集合（目的使用iterator，因Map集合没有实现iterator接口，所以必须得转）
//        Iterator<Map.Entry<String,Object>> it =  m.entrySet().iterator();
//        Map.Entry<String,Object> entry = it.next();
//        System.out.println(it); // java.util.HashMap$EntryIterator@c39f790
//        System.out.println(entry); // a=1
//        System.out.println("---------------------");

        Set<String> key = m.keySet();
        Collection<Object> values = m.values();
        System.out.println(key); // [a]
        System.out.println(values); // [1]


    }

}

class A {}
class B extends A {}
interface IA {}
class IB implements IA {}
class IC implements IA {}

