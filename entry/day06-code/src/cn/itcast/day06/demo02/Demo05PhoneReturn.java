package cn.itcast.day06.demo02;

public class Demo05PhoneReturn {
    public static void main(String[] args) {
        Phone one = getPhone();
        System.out.println(one.brand); // 苹果
    }

    public static Phone getPhone() {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8300.0;
        one.color = "白色";
        // 当时用一个对象类型作为方法值时，其实返回的就是对象的地址值
        return one;
    }
}
