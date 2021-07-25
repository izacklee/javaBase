package cn.itcast.day13.demo10;

/*
    定义一个创建数组函数式的接口
*/
@FunctionalInterface
public interface ArrayBuilder {

    // 定义一个创建int类型数组的方法，参数传递数组的长度，返回创建好的int类型数组
    public abstract int[] builderArray(int length);

}
