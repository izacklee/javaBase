package cn.itcast.day06.demo02;

public class Demo04PhoneParam {
    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 5888.0;
        one.color = "黑色";
        // 当对象作为参数，传递进方法的时候
        // 实际上是对象的地址值
        // one为Phone创建出来的地址值
        method(one);

    }
    public static void method(Phone p) {
        System.out.println(p.brand);
    }
}
