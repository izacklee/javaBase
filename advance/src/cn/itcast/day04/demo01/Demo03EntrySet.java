package cn.itcast.day04.demo01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Map集合中遍历的第二种方式：
Map集合中的方法：
     Set<Map.Entry<K,V>>	entrySet()：返回此映射中包含的映射关系的 Set 视图。
实现步骤：
    1.使用Map集合中的方法entrySet()，把Map集合中的对象取出来，存到一个set集合中
    2.遍历set集合，获取每一个Entry对象
    3.使用Entry对象中的getKey()和getValue()方法获取键与值
*/
public class Demo03EntrySet {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("王丽坤",166);
        map.put("迪丽热巴",165);
        map.put("古力娜扎",162);

        // 获取集合中的对象
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        // 遍历set集合获取集合中的每一个Entry对象
        for (Map.Entry<String,Integer> entry : set) {
            // 获取对象中的key值
            String key = entry.getKey();
            // 获取对象中的value值
            Integer val = entry.getValue();
            System.out.println(key + "=" + val);
        }
    }

}
