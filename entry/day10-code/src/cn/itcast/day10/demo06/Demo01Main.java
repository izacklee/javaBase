package cn.itcast.day10.demo06;

/*
向上转型一定是安全的，没有问题的，正确的。但也有一个弊端：
对象一旦向上转型为父类，那么就无法调用子类原本特有的内容。

解决方案：用对象的向下转型【还原】

格式：
向上转型：父类名称 对象名 = new 子类名称
向下转型：子类名称 对象名 = (子类名称) 父类对象
*/
public class Demo01Main {

    public static void main(String[] args) {
        // 对象向上转型，就是：父类引用指向子类对象（多态）
        Animal animal = new Cat();
        animal.eat(); // 猫吃鱼

//        animal.catchMouse(); // 错误写法！

        // 对象向下转型
        Cat cat = (Cat) animal;
        cat.catchMouse(); // 猫爪老鼠

        // 下面是错误的向下转型
        // 本来new的是一只猫，非要当作狗
        // 错误写法！编译不会报错，但是运行会报错，ClassCastException：类转换异常
//        Dog dog = (Dog) animal;
//          dog.watchHouse();

    }

}
