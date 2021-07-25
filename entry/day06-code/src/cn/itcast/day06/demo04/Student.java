package cn.itcast.day06.demo04;
/*
构造函数，构造方法，构造器（其实意思都一样）

构造方法是专门用来创建对象的方法，当我们用new关键字创建对象的时候，其实就是在调用构造方法。
格式：
    public 类名称(参数类型 参数名称, ...){
        方法体
    }

注意事项：
    1.构造方法的方法名称必须和所在类的名称完全一样，就连大小写也要一样。
    2.构造方法不需要写返回值类型，连void都不要写。
    3.构造方法不能return一个返回值
    4.如果没有写构造方法，那么编译器将会隐藏赠送一个构造方法，无参数，方法什么事情都不做。
        public Student() {}
    5.一旦编写了至少一个构造方法，那么编译器将不在赠送。
    6.构造方法也可以重载的。
        方法名称相同，参数列表不同。

参数列表是外部调用方法时，需要传递到方法内部进行运算的具体数据。
*/
public class Student {
    private String name; // 姓名
    private int age; // 年龄

    // 无参数的构造方法
    public Student() {
        System.out.println("构造方法执行了！");
    }

    // 有参数的构造方法
    public Student(String name, int age) {
        System.out.println("全参数的构造方法执行了！");
        this.name = name;
        this.age = age;
    }

    // getter setter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
