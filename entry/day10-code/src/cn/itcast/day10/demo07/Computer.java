package cn.itcast.day10.demo07;

public class Computer {

    public void powerOn() {
        System.out.println("打开笔记本电脑");
    }

    public void powerOff() {
        System.out.println("关闭笔记本电脑");
    }

    // 使用USB设备的方法，使用接口作为方法的参数
    public void useDevice(USB usb) {
        usb.open(); // 打开设备
        if (usb instanceof Mouse) { // 首先要判断下
            Mouse mouse = (Mouse) usb;  // 向下转型
            mouse.click();
        } else if (usb instanceof Keyboard) {
            Keyboard keyboard = (Keyboard) usb; // 向下转型
            keyboard.type();
        }
        usb.close(); // 关闭设备
    }
}
