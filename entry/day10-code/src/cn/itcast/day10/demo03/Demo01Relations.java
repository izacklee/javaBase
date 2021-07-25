package cn.itcast.day10.demo03;
/*
1.类与类之间是单继承的。直接父类只有一个。
2.类与接口之间是多实现的。一个类可以实现多个接口。
3.接口与接口之间是多继承的。

注意事项：
1.多个接口当中抽象方法有重复，没关系。
2.多个父类接口当中的默认方法如果有重复，子接口必须进行默认方法的覆盖重写，【而且带着default关键字】
因为是接口，接口当中的关键字是不能省略的。
*/
public class Demo01Relations {

    public static void main(String[] args) {
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.method();
    }
}
