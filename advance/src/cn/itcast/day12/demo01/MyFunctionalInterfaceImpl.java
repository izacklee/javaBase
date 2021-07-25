package cn.itcast.day12.demo01;

/*
     @Override：检测是否覆盖重写父类的方法的注释
        是：编译成功
        否：编译失败
*/
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {

    @Override
    public void method() {
        System.out.println("覆盖重写父类的抽象方法！");
    }

}
