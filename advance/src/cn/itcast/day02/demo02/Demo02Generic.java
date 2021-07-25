package cn.itcast.day02.demo02;

/*
定义一个含有泛型的类，模拟ArrayList集合
泛型是一个未知的数据类型，当我们不确定什么数据类型的时候，可以使用泛型
泛型可以接收任意的数据类型，比如:Integer、String、Student...
创建对象的时候就要确定泛型的数据类型
*/
public class Demo02Generic {

    public static void main(String[] args) {
        // 不写泛型，默认为Object类型
        Generic g = new Generic();
        g.setName("只能是字符串"); // 修改类为泛型类之前，只能传字符串
        g.setName(111); // 修改类为泛型之后，支持传整型了

        Object str = g.getName();
        System.out.println(str); // 111

        // 创建对象 指定泛型为Integer类型
        Generic<Integer> g1 = new Generic<>();
//        g1.setName("胡歌");  // 错误写法！
        g1.setName(222);
        Integer in = g1.getName();
        System.out.println(in); // 222

        // 创建对象 指定泛型为String类型
        Generic<String> g2 = new Generic<>();
        g2.setName("高圆圆");
        String str1 = g2.getName();
        System.out.println(str1); // 高圆圆
    }

}
