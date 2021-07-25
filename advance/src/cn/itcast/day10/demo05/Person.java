package cn.itcast.day10.demo05;

import java.io.Serializable;

/*
    想启用序列化功能，本类必须实现Serializable接口，否则将抛出异常 java.io.NotSerializableException
 */
public class Person implements Serializable {
    // 设置serialVersionUID 解决报java.io.InvalidClassException未知类异常的问题
    static final long serialVersionUID = 1L; // 这个值必须是最终的 不可改变的

    private String name;
    public int age;
//    private transient int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
