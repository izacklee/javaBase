package cn.itcast.day01.annotation;

/*
    JDK中预定义的一些注解
        @Override：检测方法是否为有效覆盖重写父类方法
        @Deprecated：该注解标注的内容，表示已过时
        @SuppressWarnings：压制警告
            一般传递参数all， 如：@SuppressWarnings("all")
*/
@SuppressWarnings("all")
public class AnnoDemo02 {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {
        // 有缺陷
    }

    public void show2() {
        // 替代方法
    }

    public void demo() {
        show1();
    }
}
