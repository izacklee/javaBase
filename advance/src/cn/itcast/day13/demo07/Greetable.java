package cn.itcast.day13.demo07;

/*
    定义见面的函数式接口
*/
@FunctionalInterface
public interface Greetable {

    // 定义一个抽象的见面方法
    public abstract void greet();
}
