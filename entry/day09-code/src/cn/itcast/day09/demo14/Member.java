package cn.itcast.day09.demo14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// 会员类
public class Member extends User  {

    public Member() {

    }

    public Member(String name, int money) {
        super(name, money);
    }

    /*
        收红包的方法，三要素：
            返回值类型：void
            方法名称：receive
            参数列表：ArrayList<Integer>
     */
    public void receive(ArrayList<Integer> redList) {
        // 从红包当中随机抽取一个，给我自己
        // 随机获取一个集合当中的索引编号
        int index = new Random().nextInt(redList.size());

        // 获取随机红包
        int redMoney = redList.get(index);

        // 给我自己，其实就是重新设置下自己的余额
        // 最新余额 = 现有余额 + 新领取的红包
        int newMoney = super.getMoney() + redMoney;
        super.setMoney(newMoney);

        // 将已领取的红包删除
        redList.remove(index);
    }
}
