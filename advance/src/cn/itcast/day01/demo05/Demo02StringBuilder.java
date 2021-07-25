package cn.itcast.day01.demo05;

/*
StringBuilder类的成员方法：
    public StringBuilder append(...)：添加任意类型数据的字符串，并返回当前对象自身。
    参数：
        ...：可以是任意的数据类型
*/
public class Demo02StringBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abc"); // 不需要接收返回值
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = sb1.append("hello");
        System.out.println(sb1); // hello
        System.out.println(sb2); // hello
        System.out.println(sb1 == sb2); // true 两个对象是同一个对象

        System.out.println("=============");

        // 链式编程：方法的返回值是一个对象，可以根据对象继续调用方法
        System.out.println("abc".toUpperCase().toLowerCase().toUpperCase()); // ABC
        sb1.append("def").append("ghi").append("jkl");
        System.out.println(sb1); // hellodefghijkl


    }

}
