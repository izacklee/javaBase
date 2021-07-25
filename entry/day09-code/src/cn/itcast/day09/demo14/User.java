package cn.itcast.day09.demo14;

public class User {
    private String name; // 姓名
    private int money; // 余额，也就是当前用户拥有的钱数

    public User() {
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void show() {
        System.out.println("我叫：" + name + " 我的余额：" + money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
