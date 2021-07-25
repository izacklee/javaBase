package cn.itcast.day11.demo08;

/*
场景说明：
    红包发出去之后，所有人都有红包，大家抢完之后最后一个给群主。
大多数代码都是现成的，我们要做的就是填空题。
我们自己要做的事有：
    1.设置一下程序的标题，通过构造方法的字符串参数
    2.设置下群主名称
    3.设置分配策略：平均，还是随机？

红包分发的策略：
    1.普通红包（平均）：totalMoney / totalCount，余数放在最后一个红包当中。
    2.手气红包（随机）：最少1分钱，最多不超过平均数的2倍。应该越发越少。
*/
public class Bootstrap {

    public static void main(String[] args) {
        MyRed myRed = new MyRed("自学Java");
        // 设置群主名称
        myRed.setOwnerName("王思聪");

//        // 普通红包
//        NormalMode normalMode = new NormalMode();
//        myRed.setOpenWay(normalMode);

        // 手气红包
        RandomMode randomMode = new RandomMode();
        myRed.setOpenWay(randomMode);
    }
}
