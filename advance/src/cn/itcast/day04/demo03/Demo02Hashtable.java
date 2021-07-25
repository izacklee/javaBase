package cn.itcast.day04.demo03;

import java.util.HashMap;
import java.util.Hashtable;

/*
    java.util.Hashtable<k,v>集合 implements Map<k,v>接口

    HashMap：底层是一个哈希表，此实现是不同步的，是一个线程不安全的集合，是多线程集合，速度快
    Hashtable：底层也是一个哈希表，此实现是同步的，是一个线程安全的集合，是单线程集合，速度慢

    HashMap：集合（之前学的所有集合）可以存储null键，null值
    Hashtable：集合不能存储null键，null值

    Hashtable和Vector集合一样，在jdk 1.2版本之后被更先进的集合（HashMap，ArrayList）取代了
    Hashtable的子类properties依然活跃在历史舞台
    Properties集合是一个唯一和IO流相结合的集合
*/
public class Demo02Hashtable {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a","b");
        map.put(null,"a");
        map.put("c",null);
        map.put(null,null);
        System.out.println(map); // {null=null, a=b, c=null} key和value可允许null值

        Hashtable<String,String> table = new Hashtable<>();
        table.put("a","b");
        table.put("a","c");

        // key和value都不能为null值
//        table.put(null,"b"); // NullPointerException 空指针异常
//        table.put("b",null); // NullPointerException 空指针异常
//        table.put(null,null); // NullPointerException 空指针异常
        System.out.println(table);
    }

}
