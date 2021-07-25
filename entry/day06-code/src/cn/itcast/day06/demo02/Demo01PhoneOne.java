package cn.itcast.day06.demo02;

public class Demo01PhoneOne {
    public static void main(String[] args) {
        // 根据Phone类，创建一个名为phone的对象
        // 格式：类名称 对象名 = new 类名称();
        Phone phone = new Phone();
        System.out.println(phone.brand); // null
        System.out.println(phone.price); // 0.0
        System.out.println(phone.color); // null

        System.out.println("============");

        phone.brand = "苹果";
        phone.price = 5800.0;
        phone.color = "土豪金";

        System.out.println(phone.brand); // 苹果
        System.out.println(phone.price); // 5800.0
        System.out.println(phone.color); // 土豪金

        System.out.println("============");
        phone.call("乔布斯");
        phone.sendMessage();
    }
}
