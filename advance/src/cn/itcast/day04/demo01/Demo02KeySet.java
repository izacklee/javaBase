package cn.itcast.day04.demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合的第一种遍历方式：通过键找值的方式
Map集合中的方法：
    Set<K>	keySet() ：返回此映射中包含的键的 Set 视图。
实现步骤：
    1.使用Map集合中的方法keySet()，把Map集合所有的key取出来，存储到一个set集合中
    2.遍历set集合，取出Map中的每一个key
    3.通过集合中的get(key)方法，获取到对应的value值
*/
public class Demo02KeySet {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("王丽坤",166);
        map.put("迪丽热巴",165);
        map.put("古力娜扎",168);

        // 通过keySet方法取出map集合中所有的key
        Set<String> set = map.keySet();
        // 遍历set集合
        // 使用增强for遍历
        for (String key : set) {
            // 获取key对应的value值
            Integer val = map.get(key);
            System.out.println(key + "=" + val);
        }

        System.out.println("=============");

        // 使用迭代器遍历
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Integer val = map.get(key);
            System.out.println(key + "=" + val);
        }
    }
}
