package cn.itcast.day10.demo04;

/*
一个对象拥有多种形态，这就是：对象的多态性。

代码当中体现多态性，其实就是一句话：父类引用指向子类的对象。
简称：左父右子。

格式：
父类名称 对象名 = new 子类名称();
或者：
接口名称 对象名 = new 实现类名称();
*/
public class Demo01Multi {
    public static void main(String[] args) {
        // 使用多态的写法
        // 左侧父类引用，指向右侧子类对象
        Fu obj = new Zi();
        obj.method(); // 覆盖重写方法 成员方法中右边new的是谁，就优先用谁
        obj.methodFu(); // 父类特有方法

    }
}
