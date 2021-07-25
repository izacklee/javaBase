package cn.itcast.day06.demo03;

/*
对于基本类型当中的boolean值，getter方法写成isXxx，而setter规则不变。
*/

public class Student {
    private String name; // 姓名
    private int age; // 年龄
    private boolean male; // 是不是爷们儿

    public void setName(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    public void setAge(int num) {
        age = num;
    }

    public int getAge() {
        return age;
    }

    public void setMale(boolean sex) {
        male = sex;
    }

    public boolean isMale() {
        return male;
    }
}
