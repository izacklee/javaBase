package cn.itcast.day09.demo11;

public class DemoMain {
    public static void main(String[] args) {
//        Animal animal = new Animal();  // 错误写法！ 抽象类不能直接new

        Cat cat = new Cat();
        cat.eat();
    }
}
