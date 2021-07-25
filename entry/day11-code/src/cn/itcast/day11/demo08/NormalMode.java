package cn.itcast.day11.demo08;

import cn.itcast.day11.red.OpenMode;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        // 创建一个集合存储红包
        ArrayList<Integer> list = new ArrayList<>();

        int avg = totalMoney / totalCount; // 平均红包金额
        int mod = totalMoney % totalMoney; // 获取红包余数 余额，零头

        // 把平均的红包数放到集合当中，并留下最后一个
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }

        // 将最后红包余数放到最后一个红包当中
        list.add(avg + mod);

        return list;
    }
}
