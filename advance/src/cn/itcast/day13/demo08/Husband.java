package cn.itcast.day13.demo08;

/*
    通过this引用本类的成员方法
*/
public class Husband {

    // 定义一个买房的子方法
    public void buyHouse() {
        System.out.println("在北京二环内买了套四合院！");
    }

    // 定义一个结婚的方法，传递Richable接口
    public void marry(Richable r) {
        r.buy();
    }

    // 定义一个非常高兴的方法
    public void soHappy() {
        // 调用marry方法，参数传递Lambda表达式
        marry(()->{
            // 通过this调用本类的成员方法
            this.buyHouse();
        });

        // 使用this引用本类的成员方法方式
        marry(this::buyHouse);
    }

    // 定义main主方法 执行
    public static void main(String[] args) {
        new Husband().soHappy(); // 在北京二环内买了套四合院！
    }

}
