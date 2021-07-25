package cn.itcast.day01.annotation;

// 元注解
@MyAnno3

// int、String、枚举、注解、数组赋值
@MyAnno(value = 28, show2 = "迪丽热巴", per = Person.p1, anno2 = @MyAnno2, str = {"aaa","bbb"})
public class Worker {

    @MyAnno3
    public int age;

    @MyAnno3
    public void show() {

    }

}
