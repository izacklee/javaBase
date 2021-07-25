package cn.itcast.day01.domain;

public class Person {

    private String name;
    private int age;

    public String a;
    public int b;
    public int c;
    protected String sex;
    private int height;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                '}';
    }

    public void eat() {
        System.out.println("eat...");
    }

    public void eat(String food) {
        System.out.println("eat..." + food);
    }
}
