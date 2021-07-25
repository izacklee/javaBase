package cn.itcast.day09.demo14;


import java.util.ArrayList;

// 群主类
public class Manager extends User {

    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }
    /*
      发红包的方法，三要素：
           返回值类型：ArrayList<Integer>
           方法名称：send
           参数列表：
                   1.发多少钱：totalMoney
                   2.发多少个：count
     */
    public ArrayList<Integer> send(int totalMoney, int count) {
        // 创建一个红包的集合，用来存储若干个红包的金额
        ArrayList<Integer> redList = new ArrayList<>();

        // 首先看下群主有多少钱
        int leftMoney = super.getMoney();
        if (totalMoney > leftMoney) {
            System.out.println("余额不足");
            return redList; // 返回孔集合
        }

        // 扣钱 其实就是重新设置下余额
        super.setMoney(leftMoney - totalMoney);

        //发红包需要平均拆分成count份
        int avg = totalMoney / count;
        int mod = totalMoney % count;

        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        // 把平均分配剩余的钱，放到最后一个红包给包
        int last = avg + mod;
        redList.add(last);

        return redList;
    }
}
