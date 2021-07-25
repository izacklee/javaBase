package cn.itcast.day10.demo07;

public class DemoMain {
    public static void main(String[] args) {
        // 首先创建一个笔记本电脑类
        Computer computer = new Computer();
        computer.powerOn(); // 打开笔记本电脑

        // 使用鼠标 创建父类USB引用指向子类Mouse对象 多态
        // 向上转型
        USB mouse = new Mouse();
        // 参数是USB类型，我正好传递进去的就是USB鼠标
        computer.useDevice(mouse);

        // 创建一个USB键盘
        // 没有使用多态
        Keyboard keyboard = new Keyboard();
        // 参数是USB类型，传递进去的是实现类的对象
        computer.useDevice(keyboard); // 正确写法！实现类可以发生向上转型变成接口类
        // 使用子类对象，匿名对象，也可以
//        computer.useDevice(new Keyboard()); // 也是正确写法

        computer.powerOff(); // 关闭笔记本电脑

        System.out.println("=========");

        method(10.0); // 正确写法 double --> double
        method(12); // 正确写法 int --> double
        int num = 15;
        method(num); // 正确写法 int --> double

    }

    public static void method(double num) {
        System.out.println(num);
    }
}
