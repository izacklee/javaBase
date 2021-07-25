package cn.itcast.day13.demo06;

/*
    通过类名引用静态成员方法
    条件：类已经存在，静态成员方法已经存在
    就可以通过类名引用静态成员方法
*/
public class Demo01StaticMethodReference {

    public static void main(String[] args) {
        // 调用method方法，参数传递Lambda表达式
        int number = -10;
        int abs = method(number, num -> Math.abs(num));
        System.out.println(abs); // 10

        // 调用method方法，参数使用类名引用静态成员方法方式
        int abs2 = method(number, Math::abs);
        System.out.println(abs2); // 10


    }

    /*
        定义一个方法
            方法名称：method
            返回值类型：int
            参数列表：int number, Calculate c
    */
    public static int method(int number, Calculate c) {
        return c.calsAbs(number);
    }

}
