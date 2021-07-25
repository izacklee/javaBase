package cn.itcast.day10.demo01;

/*
注意事项：不能通过实现类的对象来调用接口当中的静态方法。原因是一个实现类可以实现多个接口，存在冲突的可能。
正确用法：通过接口名称，直接调用接口当中的静态方法。
格式：接口名称.静态方法(参数)
*/
public class Demo03Interface {
    public static void main(String[] args) {
        MyInterfaceStaticImpl impl = new MyInterfaceStaticImpl();
        // 错误写法！
//        impl.methodStatic();

        // 通过接口名称来调用接口当中的静态方法
        MyInterfaceStatic.methodStatic();
    }
}
