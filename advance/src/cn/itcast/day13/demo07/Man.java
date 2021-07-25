package cn.itcast.day13.demo07;

/*
    定义一个子类
*/
public class Man extends Human {

    // 覆盖重写父类的方法
    @Override
    public void sayHello() {
        System.out.println("Hello 我是Man!");
    }

    // 定义一个参数传递Greetable接口的方法
    public void method(Greetable g) {
        g.greet();
    }

    // 定义一个show方法，掉用method方法
    public void show() {
       /* method(()->{
           *//* // 创建父类Human对象
            Human human = new Human();
            human.sayHello();*//*

            // 通过super方式调用父类方法
            super.sayHello();
        });
       */

        // 使用super引用方法，优化Lambda表达式
        method(super::sayHello);
    }

    // 定义main主方法，用于运行程序
    public static void main(String[] args) {
        new Man().show(); // Hello 我是Human！
    }

}
