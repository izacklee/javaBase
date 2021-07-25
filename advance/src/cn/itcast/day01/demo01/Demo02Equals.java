package cn.itcast.day01.demo01;

public class Demo02Equals {
    public static void main(String[] args) {
        /*
         Object的equals方法
         boolean	equals(Object obj)  指示其他某个对象是否与此对象“相等”
         参数：
             Object obj：可以传递任意对象
         基本数据类型：比较的是数值
         引用数据类型：比较的是地址值
        */

        Person p1 = new Person("王丽坤", 18);
        Person p2 = new Person("高圆圆", 18);

        System.out.println(p1==p2); // false

        boolean b = p1.equals(p2);
        System.out.println(b); // false

        // 覆盖重写equals方法后再执行这部分代码，结果为true了
        Person p3 = new Person("迪丽热巴", 26);
        Person p4 = new Person("迪丽热巴", 26);

        boolean b1 = p3.equals(p4);
        System.out.println(b1); // true;

    }
}
