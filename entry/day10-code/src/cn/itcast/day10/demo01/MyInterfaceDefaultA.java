package cn.itcast.day10.demo01;

public class MyInterfaceDefaultA implements MyInterfaceDefault{

    @Override
    public void methodAbs() {
        System.out.println("实现了抽象方法，AAA");
    }

    @Override
    public void methodDefault() {
        System.out.println("实现类覆盖重写了接口默认方法，AAA");
    }
}
