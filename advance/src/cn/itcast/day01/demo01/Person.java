package cn.itcast.day01.demo01;

import java.util.Objects;

public class Person {

    private String name;

    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    /*
        直接打印对象的地址值没有意义，所以需要覆盖重写Object超类的toString方法
        输出name, age
    */
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name = '" +name + "', " +
//                "age = "+ age +
//                "}";
//    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
     equals的参数为Object o父类对象，发生了向上转型，也就是多态
     想要使用子类的属性或方法，需要【向下转型】还原为子类对象
     三个判断解释：
        this == o：如果当前对象和传递进来的对象相等，就无需比较，返回true。可提高效率。
            this是调用equals方法的对象，谁调用就是谁。
        o == null：如果当前对象为null，也就没必要比较了，直接返回false。
        getClass() !=o.getClass()：目的是判断new的对像是不是传递进来的对象，是的话才可向下转型。
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }
}
