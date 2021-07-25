/*
    自定义注解
        格式：
            元注解
            public @interface 注解名称{}

        本质：注解本身就是一个接口，该该接口继承Annotation接口
            public interface MyAnno extends java.lang.annotation.Annotation {}

    Java编译命令：javac
    Java反编译命令：javap
*/
public @interface MyAnno {
}
