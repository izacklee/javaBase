package cn.itcast.day09.demo08;

/*
super关键字的用法有三种：
1.在子类的成员方法中，访问父类的成员变量。
2.在子类的成员方法中，访问父类的成员方法。
3.在子类的构造方法中，访问父类的构造方法。
*/
public class Zi extends Fu {
    public Zi() {
        // 访问父类的构造方法
        super();
    }

    public void methodZi() {
        // 访问父类的成员变量
        int num = super.num;
        System.out.println(num);
    }

    @Override
    public void method() {
        // 访问父类的成员方法
        super.method();
        System.out.println("子类方法");
    }
}
