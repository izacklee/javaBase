package cn.itcast.day06.demo03;

/*
局部变量和成员变量

1.定位的位置不一样【重点】
    局部变量：定义在方法内部
    成员变量：定义在方法的外部，直接写在类里
2.作用范围不一样【重点】
    局部变量：只能在方法当中使用，出了方法就不能用了。
    成员变量：整个类全都可以通用。
3.默认值不一样【重点】
    局部变量：没有默认值，想要使用，必须手动赋值。
    成员变量：有默认值，规则和数组是一样的。
4.内存的位置不一样（了解）
    局部变量：位于栈内存
    成员变量：位于堆内存
5.生命周期不一样（了解）
    局部变量：随着方法进栈而产生，随着方法出栈而消失。
    成员变量：随着对象的创建而产生，随着对象被垃圾回收而消失。
 */
public class Demo01VariableDefference {
    String name; // 成员变量
    public void methodA() {
        int num = 10; // 局部变量
        System.out.println(num);
        // 成员变量在当前类里的调用格式，直接在写变量的名称即可
        System.out.println(name);
    }
    public void methoB(int param) { // 方法的参数就是局部变量
        // 这里使用局部变量的时候，没有手动赋值
        // 原因是：参数在调用方法的时候，必然会赋值的。
        System.out.println(param);

        int age;
       // System.out.println(age); // 错误写法，局部变量没有赋值不能用。
    }
}
