package cn.itcast.day13.demo09;

/*
    定义一个创建Person对象的函数式接口
*/
@FunctionalInterface
public interface PersonBuilder {

    // 定义一个抽象方法，传递姓名，创建Person对象返回
    public abstract Person builderPerson(String name);
}
