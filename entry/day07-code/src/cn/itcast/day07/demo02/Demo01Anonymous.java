package cn.itcast.day07.demo02;
/*
创建对象的标准格式：
    类名称 对象名 = new 类名称();

匿名对象就是只有右边的对象，没有左边的赋值和运算符
    new 类名称();

注意事项：
    1.匿名对象只能使用唯一一次，下次再想使用必须再创建一个新的对象
使用建议：
    1.如果确定一个一个对象只使用一次的话，那么就可以用匿名对象。
*/
public class Demo01Anonymous {
    public static void main(String[] args) {
        // 创建对象的标准格式
        Person person = new Person();
        person.name = "高圆圆";
        person.showName();

        System.out.println("==========");

        new Person().name = "赵又廷";
        new Person().showName(); // 我叫null
    }
}
