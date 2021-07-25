package cn.itcast.day11.demo08;

import cn.itcast.day11.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode {

    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        // 随机分配，有可能多，有可能少 (以10元，发3个手气红包分析)
        // 最少1分，最多不超过“剩下金额的平均数的2倍”
        // 第一次发红包，随机范围应该是0.01~6.66元
        // 第一次发完后，剩下至少3.34元
        // 此时还需要再发2个红包
        // 此时再发的范围应该是0.01~3.34元（取不到右边，剩下0.01）

        // 总结一下，范围的【公式】是：1 + random.nextInt((leftMoney / leftCount) * 2)  // 随机数+1意思是最少1分钱
        // 首先创建一个随机数生成器
        Random r = new Random();
        // totalMoney是总金额，totalCount是总份数，不变
        // 额外定义两个变量记录
        int leftMoney = totalMoney; // 剩下多少钱，递减
        int leftCount = totalCount; // 剩下多少分，递减

        // 随机发前是n-1个，最后一个不需要随机
        for (int i = 0; i < totalCount - 1; i++) {
            int money = r.nextInt((leftMoney / leftCount) * 2) + 1;
            list.add(money); // 将一个随机红包放入集合
            leftMoney -= money; // 将放入集合的钱减掉
            leftCount--;  // 将已发出的份数减掉
        }
        // 最后一个不用随机，直接放进去得了
        list.add(leftMoney);

        return list;
    }
}
