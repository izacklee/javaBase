package cn.itcast.day06.demo04;

public class Demo02Student {
    public static void main(String[] args) {
        Student stu = new Student();
        Student stu2 = new Student("胡歌", 28);

        System.out.println("我是" + stu2.getName() + "，年龄" + stu2.getAge());
        // 如果想要改变成员变量的数据内容，那么还是需要用到setXxx方法。
        stu2.setAge(30); // 改变年龄为30
        System.out.println("我是" + stu2.getName() + "，年龄" + stu2.getAge());
    }
}
