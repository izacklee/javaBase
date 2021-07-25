package cn.itcast.day01.demo06;

/*
自动装箱与自动拆箱：
    基本类型的数据与包装类之间可以自动转换
    JDK 1.5 之后出现了新特性
*/
public class Demo02Integer {

    public static void main(String[] args) {
        /*
            自动装箱：直接把int类型数据赋值给包装类
            Integer in = 1; 就相当于 Integer in = new Integer(1);
        */

        Integer in = 1;

        /*
            自动拆箱：in是包装类，不能直接参与运算，自动转换为基本类型之后，再参与运算
            in + 2; 就相当于：in.intValueOf() + 2 = 3;
        */

        in = in + 2;
        System.out.println(in);

        /*
         ArrayList集合其实也是通过add方法装箱，get方法拆箱这么一个过程。
        */
    }
}
