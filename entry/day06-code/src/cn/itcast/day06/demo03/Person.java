package cn.itcast.day06.demo03;

/*
问题描述：定义Person年龄时，无法阻止不合理的数被设置进来。
解决方案：用private将需要保护的成员变量进行修饰。

注意：一旦使用了private进行修饰，只有在本类当中随意访问，
但是！超出本类范围之外就不能直接访问了。

间接访问private成员变量，需要定义一对Getter/Setter方法
    必须叫getXxx或者是setXxx的命名规则。
    对于getter来说，不能有参数，返回值的类型和成员变量对应。
    对于setter来说，不能有返回值，参数类型和成员变量对应。

*/
public class Person {
    String name; // 姓名
    private int age; // 年龄

    public void show() {
        System.out.println("我是" + name + ", 年龄为：" + age);
    }
    // 这个成员方法，专门向age设置数据
    public void setAge(int num) {
        if (100 > num && num > 0) {
            age = num;
        } else {
            System.out.println("数据错误!");
        }
    }
    // 这个成员方法，专门获取age的数据
    public int getAge() {
        return age;
    }
}
