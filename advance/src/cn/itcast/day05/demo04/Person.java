package cn.itcast.day05.demo04;

public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void run() {
        // 线程任务
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "-->" + i);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
