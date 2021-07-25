package cn.itcast.day04.demo05;

import java.util.*;

/*
    斗地主综合案例：
        1.准备牌
        2.洗牌
        3.发牌
        4.排序
        5.看牌
*/
public class Demo03PokerPractise {

    public static void main(String[] args) {
        // 1.准备牌
        // 花色
        List<String> color = List.of("♠", "♠", "♣", "♢");
        // 序号
        List<String> serial = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        // 牌的索引集合
        List<Integer> indexList = new ArrayList<>();
        // 牌的集合
        Map<Integer,String> poker = new HashMap<>();

        // 组装牌
        int index = 0;
        poker.put(index,"大王");
        indexList.add(index);
        index++;
        poker.put(index,"小王");
        indexList.add(index);
        index++;
        for (String s : serial) {
            for (String c : color) {
                poker.put(index,c+s);
                indexList.add(index);
                index++;
            }
        }
//        System.out.println(poker);
//        System.out.println(indexList);

        // 2.洗牌
        Collections.shuffle(indexList);
//        System.out.println(indexList);

        // 3.发牌
        /*
            1.准备4个集合，装底牌以及3个玩家的牌的索引
            2.循环发牌
                2.1、索引>=51，为底牌；
                2.2、索引%3=0，给玩家1发牌；
                2.3、索引%3=1，给玩家2发牌；
                2.4、索引%3=2，给玩家3发牌。
        */

        List<Integer> dipai = new ArrayList<>();
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();

        for (int i = 0; i < indexList.size(); i++) {
            int in = indexList.get(i);
            // 是否为底牌
            if (i >= 51) {
                dipai.add(in);
            } else if (i % 3 ==0) { // 玩家1
                player1.add(in);
            } else if (i % 3 ==1) { // 玩家2
                player2.add(in);
            } else if (i % 3 ==2) { // 玩家3
                player3.add(in);
            }
        }

        // 4.排序
        Collections.sort(dipai);
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);

        // 5.看牌
        /*
            1.写一个lookPoker方法，解决代码复用性
            2.参数列表
                2.1、String name：玩家的姓名
                2.2、List<Integer> list：玩家的牌
                2.3、Map<Integer,String> poker：总的牌
        */
        lookPoker("玩家1",player1,poker);
        lookPoker("玩家2",player2,poker);
        lookPoker("玩家3",player3,poker);
        lookPoker("底牌",dipai,poker);

    }

    // 看牌的方法
    public static void lookPoker(String name, List<Integer> list, Map<Integer,String> poker) {
        List<String> pd = new ArrayList<>();
        for (Integer i : list) {
            String value = poker.get(i);
            pd.add(value);
        }
        System.out.println(name + ":" + pd);
    }

}
