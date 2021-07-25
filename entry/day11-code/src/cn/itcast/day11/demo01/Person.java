package cn.itcast.day11.demo01;

/*
对于成员变量来说，如果使用final关键字，这个成员变量也是不可改变的。

1.由于成员变量有默认值，所以final之后必须手动赋值，赋值之后不在有默认值。
2.对于final的成员变量，要么直接赋值，要么通过构造方法赋值。二者选其一。
3.通过构造方法赋值，必须保证所有重载的构造方法，都给final成员变量赋值。
*/

public class Person {

    private final String name /*= "高圆圆"*/;

    public Person() {
        this.name = "关晓彤";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
