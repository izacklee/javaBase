package cn.itcast.day09.demo07;

public class Zi extends Fu {
    public Zi() {
//        super(); // 在调用父类无参的构造方法
        super(10); // 调用父类有参数的构造方法。
        System.out.println("子类构造方法执行了！");
    }

    public void method() {
//        super(); // 错误写法！只有子构造方法才能调用父类构造方法。
    }
}
