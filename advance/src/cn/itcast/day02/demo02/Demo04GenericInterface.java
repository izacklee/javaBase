package cn.itcast.day02.demo02;

public class Demo04GenericInterface {

    public static void main(String[] args) {
        // 创建未明确指定某种泛型实现类的对象
        GenericInterfaceImpl1 impl1 = new GenericInterfaceImpl1();
        // 运行含泛型的方法
        impl1.method("aaa"); // aaa
        impl1.method(222); // 222

        GenericInterfaceImpl1<Integer> impl2 = new GenericInterfaceImpl1<>();
        impl2.method(111); // 111

        // 创建指定泛型为String类型的对象
        GenericInterfaceImpl2 impl3 = new GenericInterfaceImpl2();
        impl3.method("只能传字符串");  // 只能传字符串

    }

}
