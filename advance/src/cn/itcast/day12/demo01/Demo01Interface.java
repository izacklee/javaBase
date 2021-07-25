package cn.itcast.day12.demo01;

/*
    函数式接口的使用：一般可以作为方法的参数和返回值的类型
*/
public class Demo01Interface {

    public static void main(String[] args) {
        // 调用show方法，参数可以传递接口的实现类对象
        show(new MyFunctionalInterfaceImpl());

        // 调用show方法，参数是一个接口，可以用匿名内部类的方式
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类的方式调用");
            }
        });

        // 调用show方法，参数是一个接口，而接口为函数式接口，可以以用Lambda表达式
        show(()-> System.out.println("使用Lambda表达式调用"));
    }

    // 定义一个方法，参数使用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myInter) {
        myInter.method();
    }

}
