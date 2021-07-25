package cn.itcast.day12.demo02;

/*
    使用Lambda优化日志案例
    Lambda的特点：延迟加载
    Lambda的使用前提，必须存在函数式接口
*/
public class Demo02Lambda {

    public static void main(String[] args) {
        // 定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        // 使用Lambda表达式调用showLog方法
        showLog(2, ()->{
            // level不等于1级时，这语句就不会输出，也就是说下面的字符拼接不会执行，避免了性能浪费
            System.out.println("字符串拼接语句执行了");
            return msg1 + msg2 + msg3;
        });

        // 再简化Lambda表达式
        showLog(1, ()->msg1 + msg2 + msg3);
    }

    // 定义一个方法，传递日志等级和接口MessageBuilder
    public static void showLog(int level, MessageBuilder mb) {

        // 如果日志等级等于1级，则调用接口的builder方法
        if (level == 1) {
            String msg = mb.builder();
            System.out.println(msg);
        }
    }

}
