package cn.itcast.day13.demo08;

/*
    定义一个富有的函数式接口
*/
@FunctionalInterface
public interface Richable {

    // 定义一个抽象的想买什么就买什么的方法
    public abstract void buy();
}
