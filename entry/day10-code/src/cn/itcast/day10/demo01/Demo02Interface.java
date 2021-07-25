package cn.itcast.day10.demo01;

/*
1.接口的默认方法，可以通过接口实现类对象，直接调用。
2.接口的默认方法，也可以被接口实现类覆盖重写。
*/
public class Demo02Interface {
    public static void main(String[] args) {
        // 创建实现类A的对象，并使用
        MyInterfaceDefaultA implA = new MyInterfaceDefaultA();
        implA.methodAbs(); // 抽象方法，运行的是右侧实现类

        // 默认方法，如果实现类当中没有，则向上查找
        implA.methodDefault();
        System.out.println("===========");

        // 创建实现类B的对象，并使用
        MyInterfaceDefaultB implB = new MyInterfaceDefaultB();
        implB.methodAbs();
        implB.methodDefault();
    }
}
