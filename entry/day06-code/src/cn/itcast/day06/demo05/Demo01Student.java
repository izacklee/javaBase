package cn.itcast.day06.demo05;

public class Demo01Student {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("王丽坤");
        stu.setAge(20); // 修改年龄
        System.out.println("素颜女神：" + stu.getName() + " 年龄：" + stu.getAge());

        Student stu2 = new Student("杨超越", 18);
        System.out.println("姓名：" + stu2.getName() + " 年龄：" + stu2.getAge());
        stu2.setAge(20);
        System.out.println("姓名：" + stu2.getName() + " 年龄：" + stu2.getAge());
    }
}
