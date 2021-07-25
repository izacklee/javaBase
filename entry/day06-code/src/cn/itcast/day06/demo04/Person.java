package cn.itcast.day06.demo04;
/*
当方法中的局部变量与成员变量重名时，就根据“就近原则”，优先使用局部变量。

如果需要访问本类中的成员变量，格式：
    this.成员变量名称

“通过谁调用的方法，谁就是this”
*/
public class Person {
    String name; // 姓名

    public void sayHello(String name) {
        // 局部变量与成员变量重名，优先使用局部变量。
//        System.out.println("你好，我叫：" + name + ", 我爸是" + name + "。");
        System.out.println("你好，我叫：" + this.name + ", 我爸是" + name + "。");
    }
}
