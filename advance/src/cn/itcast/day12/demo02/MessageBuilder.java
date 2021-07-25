package cn.itcast.day12.demo02;

@FunctionalInterface
public interface MessageBuilder {

    // 定义一个抽象方法，返回拼接的消息
    public abstract String builder();

}
