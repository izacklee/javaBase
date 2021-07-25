package cn.itcast.day07.demo04;

/*
    需求：
        给定一个厨子Cook接口，内含唯一的抽象方法makeFood，且无参数，无返回值。
        使用Lambda的标准格式调用invokeCook方法，打印输出“吃饭啦！”字样
*/
public class Demo01Cook {

    public static void main(String[] args) {
        // 调用invokeFood方法 参数是Cook接口
        invokeFood(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭啦！");
            }
        });

        // 使用Lambda表达式 函数式编程思想，只重视结果，不重视过程
        invokeFood(() -> System.out.println("吃饭啦！"));
    }
    // 定义一个方法，参数是Cook接口，调用makeFood方法
    public static void invokeFood(Cook c) {
        c.makeFood();
    }

}
