package cn.itcast.day07.demo03;

/*
    使用Lambda表达式实现多线程

    Lambda表达式的标准格式：
        由三部分组成：
            a.一些参数
            b.一个箭头
            c.一段代码
        格式：
            (参数列表) -> {一段代码}
        格式说明：
            ()：接口中抽象方法的参数列表，没有参数，就空着，有参数就写出参数，多个参数使用逗号分隔，
                只有一个参数时可省略()，直接写参数即可
            ->：传递的意思，把参数传递给方法体{}
            {}：重写接口的抽象方法的方法体
*/
public class Demo02Lambda {

    public static void main(String[] args) {
        // Lambda表达式实现多线程
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
        }).start();

        // 再简化
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "创建了一个新的线程")).start();
    }

}
