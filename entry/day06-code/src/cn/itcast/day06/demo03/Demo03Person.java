package cn.itcast.day06.demo03;

public class Demo03Person {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "范冰冰";
//        person.age = -20;
      //  person.setAge(-20); // 0
        person.setAge(21);
        person.show();
    }
}
