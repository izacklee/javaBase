package cn.itcast.day02.demo02;

/*
    没有明确指定某泛型实现类
*/
public class GenericInterfaceImpl1<M> implements GenericInterface<M>{

    @Override
    public void method(M i) {
        System.out.println("含泛型实现类覆盖重写的方法执行了，参数为：" + i);
    }
}
