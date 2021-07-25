package cn.itcast.day10.demo06;

/*
如何才能知道一个父类的引用对象，原来是什么子类？

格式：
对象 instanceof 类名称
这会得到一个boolean值，也就是判断前面的对象能不能当作后面类型的实例。
*/
public class Demo02Instanceof {

    public static void main(String[] args) {
        Animal animal = new Cat(); // 本来是一只猫
        animal.eat(); // 猫吃鱼
        // 如果想调用子类特有的方法，需要向下转型
        // 判断animal原来的子类是不是Cat
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMouse();  // 猫爪老鼠
        } else if (animal instanceof Dog) {  // 判断一下原来的子类是不是Dog
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
        giveMeAPet(animal);
    }

    public static void giveMeAPet(Animal animal) {
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMouse();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
    }


}
