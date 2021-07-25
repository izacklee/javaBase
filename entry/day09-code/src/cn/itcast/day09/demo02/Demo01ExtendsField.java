package cn.itcast.day09.demo02;
/*
在父类的继承关系中，如果成员变量重名，则创建子对象时，访问有两种方式：

直接通过子对象访问成员变量：
    等号左边是谁，就优先用谁，没有则向上找。
间接通过成员方法访问成员变量：
    该方法属于谁，就优先用谁，没有则向上找。
*/
public class Demo01ExtendsField {
    public static void main(String[] args) {
        // 创建父对象
        Fu fu = new Fu();
        System.out.println(fu.numFu); // 只能使用父的东西，没有任何子类内容
        System.out.println("===========");

        Zi zi = new Zi();
        System.out.println(zi.numFu); // 10
        System.out.println(zi.numZi); // 20

        // 等号左边是谁，就优先使用谁
        System.out.println(zi.num); // 优先子类 200
//        System.out.println(zi.abc); // 到处都没有，编译器报错

        // 这个方法是子类的，则优先使用谁的，没有向上找
        zi.methodZi(); // 200

        // 这个方法是在父类中定义的
        zi.methodFu(); // 100
    }
}
