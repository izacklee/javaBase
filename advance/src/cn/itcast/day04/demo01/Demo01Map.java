package cn.itcast.day04.demo01;

import java.util.HashMap;
import java.util.Map;


/*
java.util.Map<k,v>集合
Map集合的特点：
    1.Map集合是一个双列集合，一个元素包含两个值（一个key，一个value）
    2.Map集合中的元素，key与value的数据类型可以相同，也可以不同
    3.Map集合中的元素，key不可以重复，value可以重复
    4.Map集合中的元素，key与value是一一对应

常用的方法：
    public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
        返回值：
            key不重复，返回值是null
            key重复，会使用新的value替换map中重复的值，并返回被替换的value值
    public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
        返回值：
            key存在，返回被删除的值
            key不存在，返回null
    public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
        返回值：
            key存在，返回对应value值
            key不存在，返回null
    public boolean containsKey(Object key) 判断集合中是否包含指定的键。
        包含返回true，不包含返回false
    public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。
    public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。

注意：返回接收的数据类型推荐使用包装类，不然特殊情况下会报错，比如：数据类型为int，但是返回值为null这种情况就会报错

java.util.HashMap<k,v>集合 implements Map<k,v>接口
HashMap集合的特点：
    1.底层是哈希表：查询速度特别快
        JDK 1.8之前：数组 + 单向链表
        JDK 1.8之后：数组 + 单向链表/红黑树（链表的长度超过8自动切换成红黑树）：提高查询的速度
    2.是一个无序的集合，存储的元素和取出的元素顺序有可能不一致

java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>集合
LinkedHashMap集合的特点：
（底层是哈希表 + 链表：查询速度特别快，增删也很快。如果需求是追求查询快并有序的话：
      复杂的数据存储可选HashMap，但如果只是简单的存储数字那就用ArrayList）
    1.底层是哈希表 + 链表（保证迭代的顺序）
    2.是一个有序的集合，存储元素和取出元素的顺序是一致的
*/
public class Demo01Map {

    public static void main(String[] args) {
//        put();
//        remove();
//        get();
        containsKey();
    }

    // containsKey方法
    private static void containsKey() {
        Map<String,Integer> map = new HashMap<>();
        map.put("王丽坤",168);
        map.put("迪丽热巴",162);
        map.put("古力娜扎",166);

        boolean b1 = map.containsKey("迪丽热巴");
        boolean b2 = map.containsKey("范冰冰");
        System.out.println(b1); // true
        System.out.println(b2); // false
    }

    // get方法
    private static void get() {
        Map<String,Integer> map = new HashMap<>();
        map.put("王丽坤",168);
        map.put("迪丽热巴",162);
        map.put("古力娜扎",166);
        Integer r1 = map.get("王丽坤");
        Integer r2 = map.get("范冰冰");

        System.out.println(r1); // 168
        System.out.println(r2); // null

    }

    // remove方法
    private static void remove() {
        Map<String,Integer> map = new HashMap<>();
        map.put("aaa",111);
        map.put("bbb",222);
        map.put("ccc",333);
        System.out.println(map); // {aaa=111, ccc=333, bbb=222}
        Integer r1 = map.remove("bbb");
        Integer r2 = map.remove("hhh");
        System.out.println(r1); // 222
        System.out.println(r2); // null
        System.out.println(map); // {aaa=111, ccc=333}
    }

    /*
        put方法
    */
    private static void put() {
        // 创建Map集合对象 多态
        Map<String,Integer> map = new HashMap<>();
        Integer r1 = map.put("迪丽热巴", 20);
        map.put("迪丽热巴", 20);
        // 自动拆箱
//        int r3 = map.put("王丽坤", 18); // 错误！！返回的数据类型不使用包装类时，返回null就报：NullPointerException空指针异常
        Integer r3 = map.put("王丽坤", 18); // 正确
        System.out.println(r3); // null
        System.out.println(map); // {迪丽热巴=20, 王丽坤=18} 无重复
    }
}
