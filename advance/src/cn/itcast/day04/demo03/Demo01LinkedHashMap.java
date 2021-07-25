package cn.itcast.day04.demo03;

import java.util.LinkedHashMap;

/*
  java.util.LinkedHashMap<k,v> extends HashMap<k,v>
  Map接口的哈希表和链表列表实现，具有可预知的迭代顺序
  底层原理：
    哈希表+链表（记录元素的顺序）
*/
public class Demo01LinkedHashMap {

    public static void main(String[] args) {
        // 创建LinkedHashMap集合的对象
        LinkedHashMap<String,String> linked = new LinkedHashMap<>();
        // 往集合添加元素
        linked.put("b","b");
        linked.put("a","a");
        linked.put("c","c");
        linked.put("a","c");

        System.out.println(linked); // {b=b, a=c, c=c} 有序 无重复

        // 遍历集合
        for (String key : linked.keySet()) {
            String value = linked.get(key);
            System.out.println(key + "=" + value);
        }
    }

}
