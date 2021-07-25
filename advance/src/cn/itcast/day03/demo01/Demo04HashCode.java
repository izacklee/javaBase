package cn.itcast.day03.demo01;

/*
    哈希值：是一个十进制的整数，由系统随机给出
    （就是对象的地址值，是一个逻辑地址，是模拟出来得到的地址，不是数据实际存储的物理地址）
    在Object类有一个方法，可以获取对象的哈希值
    int hashCode()：返回该对象的哈希码值。
    hashCode方法源码：
        public native int hashCode();
        native：代表该方法调用的是本地操作系统的方法
*/
public class Demo04HashCode {

    public static void main(String[] args) {
        // Person类继承了Object类，所以可以使用Object类的hashCode方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        // 注：当首次打印p1没有往下代码的时候结果就会出现：100555887与611437735这两个值轮换
        System.out.println(h1); // 100555887

        Person p2 = new Person();
        int h2 = p2.hashCode();
        System.out.println(h2); // 1769597131

        /*
            toString方法源码：
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
        */
        System.out.println(p1); // cn.itcast.day03.demo01.Person@5fe5c6f
        System.out.println(p2); // cn.itcast.day03.demo01.Person@6979e8cb
        System.out.println(p1==p2); // false  即便覆盖重写hashCode方法也是返回false，说明他们的物理地址不一致

        /*
            String类的哈希值
                String类重写Object类的hashCode方法
        */

        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println(s1.hashCode()); // 96354
        System.out.println(s2.hashCode()); // 96354

        // 字符串不一样，返回的哈希值是一样的
        System.out.println("重地".hashCode()); // 1179395
        System.out.println("通话".hashCode()); // 1179395
    }

}
