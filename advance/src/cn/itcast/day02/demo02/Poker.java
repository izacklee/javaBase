package cn.itcast.day02.demo02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 斗地主综合案例
    1.准备牌
    2.洗牌
    3.发牌
    4.看牌
*/
public class Poker {
    public static void main(String[] args) {
        // 1.准备牌
        //  装牌的大集合 一共54张牌
        ArrayList<String> list = new ArrayList<>();

        // 装花色的数组 4种
        String[] color = {"♠", "♠", "♣", "♢"};
        // 装序号的数组 13个
        String[] serial = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};

        // 组装牌
        list.add("大王");
        list.add("小王");
        for (int i = 0; i < color.length; i++) {
            for (int i1 = 0; i1 < serial.length; i1++) {
                list.add(color[i] + serial[i1]);
            }
        }

        // 2.洗牌
        /*
            使用Collections工具类的shuffle方法进行洗牌
            static void	shuffle(List<?> list) ：使用默认随机源对指定列表进行置换。
        */
//        System.out.print(list);
        Collections.shuffle(list);
//        System.out.println();
//        System.out.print(list);

        // 3.发牌
        // 三个人每人17张牌，i % 3，有三种结果：0 % 3 = 0； 1 % 3 = 1； 2 % 3 = 2； 3 % 3 = 0；0~2分别对应三个人
        // 当发到>=51时，留出三张底牌
        // 定义四个数组，分别装三个玩家的牌和底牌
        ArrayList<String> list01 = new ArrayList<>();
        ArrayList<String> list02 = new ArrayList<>();
        ArrayList<String> list03 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            // 留下底牌
            if (i >= 51) {
                dipai.add(list.get(i));
            } else if (i % 3 == 0) {
                // 玩家1的牌
                list01.add(list.get(i));
            } else if (i % 3 == 1) {
                // 玩家2的牌
                list02.add(list.get(i));
            } else if (i % 3 == 2) {
                // 玩家3的牌
                list03.add(list.get(i));
            }
        }

        // 4.看牌
        System.out.print("玩家1的牌：" + list01);
        System.out.println();
        System.out.print("玩家2的牌：" + list02);
        System.out.println();
        System.out.print("玩家3的牌：" + list03);
        System.out.println();
        System.out.print("底牌：" + dipai);
        System.out.println();
    }
}
