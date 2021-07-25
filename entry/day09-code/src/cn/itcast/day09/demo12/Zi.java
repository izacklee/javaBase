package cn.itcast.day09.demo12;

public class Zi extends Fu {

    public Zi() {
        // super();
        System.out.println("子类的构造方法执行了");
    }

    @Override
    public void eat() {
        System.out.println("吃饭饭");
    }
}
