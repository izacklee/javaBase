package com.zeroten.javales.day07y_reflectannotation;

public class Demo02Reflect {

    public static void main(String[] args) {
        // com.zeroten.javales.day07y_reflectannotation.Q 完全类名
        // 获取class
        // 1.通过对象来获取
//        Q q = new Q();
//        Class c = q.getClass();

        // 2.通过类来获取
        Class<Q> c2 = Q.class;

        // 3.通过局部变量来获取
        try {
            Class c3 = Class.forName("com.zeroten.javales.day07y_reflectannotation.Q");
//            System.out.println(c3); // class com.zeroten.javales.day07y_reflectannotation.Q

            // 创建对象
            // 在java中由类创建对象，一定会调用构造
            // 1.通过类来创建
            //  注意：实际上相当于new了一个对象
            // 相当于调用了一个空参构造创建对象
            c3.newInstance();

            // 父类转子类
            // 将一个类转换成另外一个的实例，如果转换异常就会抛出ClassCastException异常
//            Class<?> w = W.class.asSubclass(Q.class);
//            System.out.println(w.getTypeName()); // com.zeroten.javales.day07y_reflectannotation.W
            // 效果等同于
//            System.out.println(w.newInstance() instanceof Q);

            // 多态
//            I i = I.class.cast(new Q()); // com.zeroten.javales.day07y_reflectannotation.Q@5e481248
//            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}

interface I {

}

class Q implements I {
    public Q() {
        System.out.println("我是空参构造");
    }
}

class W extends Q {

}