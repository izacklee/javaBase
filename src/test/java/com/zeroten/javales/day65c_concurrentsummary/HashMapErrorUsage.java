package com.zeroten.javales.day65c_concurrentsummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapErrorUsage {


    private static Map<String, Integer> map = new HashMap<>();

    public void recordInfo(String key, Integer value) {

        map.put(key, value);

    }

    // 并发这才是对的（因为是局部变量 内部的）
    public void hashmapTest(List<String> list) {

        Map<String, String> map = new HashMap<>();

        list.forEach((e) -> {

            map.put(e,e);

        });

    }

    public static void main(String[] args) {

        HashMapErrorUsage errorUsage = new HashMapErrorUsage();
//        List<String> list = new ArrayList<>();

        for (int i=0; i<100; i++) {

            String key = "key-" + i;
            Integer value = i;

            new Thread(()->{

//                list.add(key);
//                errorUsage.hashmapTest(list);

                errorUsage.recordInfo(key, value);

            }).start();

        }

//        for (Map.Entry<String, Integer> m : map.entrySet()) {
//
//            System.out.println(m.getKey() + "：" + m.getValue());
//
//        }

    }

}
