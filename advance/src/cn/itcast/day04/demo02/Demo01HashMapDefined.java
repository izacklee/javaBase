package cn.itcast.day04.demo02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
HashMap存储自定义类型的键值
Map保证key唯一
    key作为键值，必须重写hashCode与equals方法，以保证key唯一
*/
public class Demo01HashMapDefined {

    public static void main(String[] args) {
//        show01();
        show02();
    }

    /*
      HashMap存储自定义类型
     key：Person类型（同名同龄视为同一个人），需重写hashCode和equals方法，可以保证key唯一
     value：String类型可重复
    */
    private static void show02() {
        Map<Person,String> map1 = new HashMap<>();
        map1.put(new Person("女王", 28),"英国");
        map1.put(new Person("总统",26),"美国");
        map1.put(new Person("主席",30),"中国");
        map1.put(new Person("女王",28),"英国");
        // 重写hashCode和equals方法之前：
        /*
            {Person{name='女王', age=28}=英国, Person{name='总统', age=26}=美国, Person{name='女王', age=28}=英国,
            Person{name='主席', age=30}=中国}
         */
        // 重写hashCode和equals方法之后：
        /*
            {Person{name='女王', age=28}=英国, Person{name='主席', age=30}=中国, Person{name='总统', age=26}=美国}
         */
//        System.out.println(map1);

        // 使用增强for遍历map1集合
        // 通过键找值的方式
        for (Person key : map1.keySet()) {
            String value = map1.get(key);
            System.out.println(key + "=" +value);
        }
        System.out.println("=========");

        // 通过entrySet的方式
        Set<Map.Entry<Person,String>> set = map1.entrySet();
        for (Map.Entry<Person,String> entry : set) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }

    }

    /*
     HashMap存储自定义类型
     key：String类型重写了hashCode和equals方法，可以保证key唯一
     value：Person类型value可以重复（同名同龄视为同一个人）
    */
    private static void show01() {
        Map<String,Person> map = new HashMap<>();
        map.put("北京",new Person("黄晓明", 28));
        map.put("北京",new Person("杨颖",26));
        map.put("上海",new Person("胡歌",28));
        map.put("深圳",new Person("马化腾",30));

        // {上海=Person{name='胡歌', age=28}, 北京=Person{name='杨颖', age=26}, 深圳=Person{name='马化腾', age=30}}
//        System.out.println(map);

        for (String key : map.keySet()) {
            Person value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }

}
