package cn.itcast.day02.demo02;

/*
指定泛型为String类型实现类：
    实现接口指定了String类型，覆盖重写的抽象方法也需要指定String类型
*/
public class GenericInterfaceImpl2 implements GenericInterface<String> {

    @Override
    public void method(String s) {
        System.out.println("指定泛型为String的方法执行了，参数：" + s);
    }
}
