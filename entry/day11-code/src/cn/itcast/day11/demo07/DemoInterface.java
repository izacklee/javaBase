package cn.itcast.day11.demo07;

import java.util.ArrayList;
import java.util.List;

/*
java.util.List 正式ArrayList所实现的接口
*/
public class DemoInterface {
    public static void main(String[] args) {
        // 左边是接口名称，右边是实现类名称，这就是多态
        List<String> list = new ArrayList<>();

        List<String> result = addName(list);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    // 接口类作为方法参数或返回值
    public static List<String> addName(List<String> list) {
        list.add("迪丽热巴");
        list.add("王丽坤");
        list.add("赵丽颖");

        return list;
    }
}
