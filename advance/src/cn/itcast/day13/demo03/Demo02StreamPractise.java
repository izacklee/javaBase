package cn.itcast.day13.demo03;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    练习：集合元素处理（Stream方式）

    将上一题当中的传统for循环写法更换为stream流处理方式。
    两个集合的初始内容不变，Person类定义也不变。
*/
public class Demo02StreamPractise {

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
        // 2. 第一个队伍筛选之后只要前3个人;存储到一个新集合中。
        Stream<String> one1 = one.stream().filter(name -> name.length() == 3).limit(3);

        // 定义第二个ArrayList集合，存储队伍成员的姓名
        ArrayList<String> two = new ArrayList<>();
        two.add("张三丰");
        two.add("周芷若");
        two.add("赵敏");
        two.add("张无忌");
        two.add("张翠山");

        // 3. 第二个队伍只要姓张的成员姓名;存储到一个新集合中。
        // 4. 第二个队伍筛选之后不要前2个人;存储到一个新集合中。
        Stream<String> two1 = two.stream().filter(name -> name.startsWith("张")).skip(2);

        // 5. 将两个队伍合并为一个队伍;存储到一个新集合中。
        // 6. 根据姓名创建 Person 对象;存储到一个新集合中。（用map映射，其实就是数据类型的转换 String -> Person）
        // 7. 打印整个队伍的Person对象信息。
        Stream.concat(one1, two1).map(name->new Person(name)).forEach(p-> System.out.println(p));


    }

}
