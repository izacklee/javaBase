package cn.itcast.day03.demo03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
   java.util.Collections是集合工具类，对集合进行操作。部分方法如下：
   public static <T> void sort(List<T> list, Comparator<? super T>)：将集合中的元素按照指定规则排序。

   Comparator与Comparable的区别
     Comparator：相当于找一个第三方裁判，比较两个
     Comparable：自己（this）和别人（参数）比较，自己需要实现Comparable接口，重写compareTo方法

  Comparator的排序规则：
    o1 - o2：升序排序
    o2 - o1：降序排序
*/
public class Demo03Sort {

    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        Collections.addAll(list01, 2, 1, 3);
        System.out.println(list01); // [2, 1, 3]

        // 使用Comparator排序
        Collections.sort(list01, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = o1 - o2; // 升序排序
                return result;
            }
        });

        System.out.println(list01); // [1, 2, 3]

        // 【了解】
        // 对集合存储的Student对象中年龄进行升序排序（扩展：年龄相同时再按首字母排序）
        ArrayList<Student> list02 = new ArrayList<>();
        Student s1 = new Student("z詹姆士",28);
        Student s2 = new Student("k科比",32);
        Student s3 = new Student("a艾弗森",28);
        Collections.addAll(list02, s1, s2, s3);
        System.out.println("排序前：" + list02);
        Collections.sort(list02, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 按年龄升序排序
                int result = o1.getAge() - o2.getAge();
                // 如果年龄相同，再按首字母排序
                if (result == 0) {
                     result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge(); // 升序排序
//            }


        });
        System.out.println("排序后：" + list02);
    }
}
