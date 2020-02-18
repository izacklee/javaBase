package com.zeroten.javales.day03y_io;

import java.io.Serializable;

// 如果没有实现Serializable接口，那么将会报java.io.NotSerializableException异常
public class Person implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private Car c;

    /*
        保证数据一致性：当成一个默认操作
    */
    private static final long serialVersionUID = - 366801;

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Car getC() {
        return c;
    }

    public Person setC(Car c) {
        this.c = c;
        return this;
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
