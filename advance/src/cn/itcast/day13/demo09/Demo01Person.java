package cn.itcast.day13.demo09;

/*
    类的构造器（构造方法）引用
*/
public class Demo01Person {

    public static void main(String[] args) {
        String name = "王丽坤";
        // 参数传递Lambda的方式
        printName(name,s->new Person(s));

        // 类的构造器引用方式
        /*
            构造方法：new Person(String s) 已知
            创建对象：new 已知
            就可以使用Person引用new创建对象
        */
        printName(name,Person::new);
    }

    /*
        定义一个方法
            方法名称：printName
            返回值类型：void
            参数列表：String name, PersonBuilder pb
     */
    public static void printName(String name, PersonBuilder pb) {
        Person p = pb.builderPerson(name);
        System.out.println(p.getName());
    }

}
