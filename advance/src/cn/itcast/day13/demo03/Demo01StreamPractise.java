package cn.itcast.day13.demo03;

import java.util.*;

/*
    练习：集合元素处理（传统方式）
        现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环(或增强for循环)依次进行以 下若干操作步骤:
        1. 第一个队伍只要名字为3个字的成员姓名;存储到一个新集合中。
        2. 第一个队伍筛选之后只要前3个人;存储到一个新集合中。
        3. 第二个队伍只要姓张的成员姓名;存储到一个新集合中。
        4. 第二个队伍筛选之后不要前2个人;存储到一个新集合中。
        5. 将两个队伍合并为一个队伍;存储到一个新集合中。
        6. 根据姓名创建 Person 对象;存储到一个新集合中。
        7. 打印整个队伍的Person对象信息。
*/
public class Demo01StreamPractise {

    public static void main(String[] args) {
        // 定义第一个队伍的ArrayList集合，存储队伍成员的姓名
        ArrayList<String> one = new ArrayList<>();
        one.add("科比");
        one.add("艾弗森");
        one.add("詹姆斯");
        one.add("库里");
        one.add("乔丹");
        one.add("张伯伦");
        one.add("易建联");

        // 1. 第一个队伍只要名字为3个字的成员姓名;存储到一个新集合中。
        ArrayList<String> one2 = new ArrayList<>();
        for (String s : one) {
            if (s.length() == 3) {
                one2.add(s);
            }
        }

        // 2. 第一个队伍筛选之后只要前3个人;存储到一个新集合中。
        ArrayList<String> one3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one3.add(one2.get(i)); // i为 0，1，2
        }

        // 定义第二个ArrayList集合，存储队伍成员的姓名
        ArrayList<String> two = new ArrayList<>();
        two.add("张三丰");
        two.add("周芷若");
        two.add("赵敏");
        two.add("张无忌");
        two.add("张翠山");

        // 3. 第二个队伍只要姓张的成员姓名;存储到一个新集合中。
        ArrayList<String> two2 = new ArrayList<>();
        for (String s : two) {
            if (s.startsWith("张")) {
                two2.add(s);
            }
        }

        // 4. 第二个队伍筛选之后不要前2个人;存储到一个新集合中。
        ArrayList<String> two3 = new ArrayList<>();
        for (int i = 2; i < two2.size(); i++) {
            two3.add(two2.get(i)); // i 不等于 0，1
        }

        // 5. 将两个队伍合并为一个队伍;存储到一个新集合中。
        ArrayList<String> all = new ArrayList<>();
        all.addAll(one3);
        all.addAll(two3);

        // 6. 根据姓名创建 Person 对象;存储到一个新集合中。
        ArrayList<Person> list = new ArrayList<>();
        for (String s : all) {
            list.add(new Person(s));
        }

        // 7. 打印整个队伍的Person对象信息。
        for (Person p : list) {
            System.out.println(p);
        }

    }

}
