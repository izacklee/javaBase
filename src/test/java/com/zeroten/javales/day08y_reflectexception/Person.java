package com.zeroten.javales.day08y_reflectexception;

public class Person {
    private Integer id;
    private String name;
    private int age;

    public Person() {
        System.out.println("调用0参构造");
    }

    public Person(Integer id) {
        System.out.println("调用1参构造");
        this.id = id;
    }

    public Person(Integer id, String name, int age) {
        System.out.println("调用3参构造");
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
