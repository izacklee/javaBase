package anno;


import java.lang.annotation.*;

/*
    元注解：用于描述注解的注解
        @Target：描述注解能够作用的位置（类，属性，方法）
            ElementType取值：
                a.TYPE：可以作用于类上
                b.METHOD：可以作用于方法上
                c.FIELD：可以作用于成员变量上
        @Retention：描述注解被保留的阶段（Java三个阶段：Source源代码阶段，Class类对象阶段，Runtime运行时阶段）
            @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会被保留到class字节码文件中，并被JVM读取到
        @Documented：描述注解是否被抽取到api文档中
        @Inherited：描述注解是否被子类继承
*/
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD}) // 表示该MyAnno3注解只能作用于类上
@Retention(RetentionPolicy.RUNTIME) // 一般用RUNTIME
@Documented
public @interface MyAnno3 {
}
