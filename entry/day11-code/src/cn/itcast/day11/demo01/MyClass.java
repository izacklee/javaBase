package cn.itcast.day11.demo01;

/*
当final用来修饰一个类的时候，格式：
public final class 类名称 {
    // ...
}

含义：当前这个类不能有任何的子类。可以有父类。（太监类）
注意：一个类如果是final的，那么其中的所有的成员方法都无法覆盖重写（因为没有儿子）。
*/
public final class MyClass {
    public void method() {
        System.out.println("方法执行了");
    }
}
