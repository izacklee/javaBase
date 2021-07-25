package cn.itcast.day07.demo01;

/*
    测试类：
    包含main方法，程序执行的入口，启动程序
    创建包子的对象
    创建包子铺线程，开启，生产包子
    创建吃货线程，开启，吃包子
*/
public class Demo01Practise {

    public static void main(String[] args) {
        // 创建包子对象
        BaoZi bz = new BaoZi();
        // 创建包子铺线程
        BaoZiPu bzp = new BaoZiPu(bz);
        // 创建吃货线程
        ChiHuo ch = new ChiHuo(bz);

        // 开启包子铺与吃货线程
        bzp.start();
        ch.start();
    }

}
