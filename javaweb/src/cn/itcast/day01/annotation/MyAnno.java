package cn.itcast.day01.annotation;

/*
    自定义注解
        格式：
            元注解
            public @interface 注解名称{ // 使用@interface自定义注解时,自动继承了java.lang.annotation.Annotation接口
                // 属性列表（也就是抽象方法）
            }

        本质：注解本身就是一个接口，该该接口继承Annotation接口
            public interface MyAnno extends java.lang.annotation.Annotation {}

        属性：接口中的抽象方法
            要求：
                1.属性的返回值类型只有下列类型
                    a.基本数据类型
                    b.String
                    c.枚举
                    d.注解
                    e.以上类型的数组

                 2.定义了属性，使用时需要给属性赋值
                    a.如果定义属性时，使用关键字default给属性赋初始值，则在使用属性时，可以不进行属性赋值
                    b.如果只有一个属性需要赋值，并且属性的名称为value，则给属性赋值时，value名称可省略，可直接写值
                    c.数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略

    Java编译命令：javac
    Java反编译命令：javap
*/
public @interface MyAnno {

    int value();

    /*String name() default "胡歌";
    int age();*/

//    public abstract int show1(); // 返回值类型 int型（基本类型）

    public abstract String show2(); // 返回值类型 String

    public abstract Person per(); // 返回值类型 枚举

    public abstract MyAnno2 anno2(); // 返回值类型 注解

    public abstract String[] str(); // 返回值类型 String数组

//    Worker w();  // 错误写法！不支持class类型

}
