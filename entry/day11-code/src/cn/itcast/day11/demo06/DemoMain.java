package cn.itcast.day11.demo06;

public class DemoMain {
    public static void main(String[] args) {
        // 创建一个英雄的角色
        Hero hero = new Hero();
        // 设置姓名与年龄
        hero.setName("盖伦");
        hero.setAge(18);

        // 创建一个武器对象
        Weapon weapon = new Weapon("多兰剑");
        // 给英雄配置武器
        hero.setWeapon(weapon);
        hero.attack(); // 年龄为18的盖伦用多兰剑攻击敌方。

        System.out.println("==============");
        // 简洁的写法
        new Hero("盖伦伦", 28, new Weapon("尚方宝剑")).attack(); // 年龄为28的盖伦伦用尚方宝剑攻击敌方。
    }
}
