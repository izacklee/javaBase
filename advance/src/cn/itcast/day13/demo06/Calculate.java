package cn.itcast.day13.demo06;

@FunctionalInterface // 表名该接口是函数式接口
public interface Calculate {
    // 定义一个抽象方法，传递一个整数，对整数的绝对值计算并返回
    public abstract int calsAbs(int number);
}
