package cn.itcast.day09.demo14;

import java.util.ArrayList;

public class MainRedPacket {

    public static void main(String[] args) {
        // 群主
        Manager manager = new Manager("群主", 100);

        // 会员
        Member one = new Member("迪丽热巴", 0);
        Member two = new Member("王丽坤", 0);
        Member three = new Member("李易峰", 0);

        // 群主与普通成员原来的余额
        manager.show(); // 100
        one.show(); // 0
        two.show(); // 0
        three.show(); // 0
        System.out.println("===========");

        // 群主发20块钱红包，分3份
        ArrayList<Integer> redList = manager.send(20, 3);

        // 普通成员领红包
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        // 群主与普通成员最新余额
        manager.show(); // 100 - 20 = 80
        // 6 、6 、8 随机分给三个普通会员
        one.show();
        two.show();
        three.show();
    }
}
