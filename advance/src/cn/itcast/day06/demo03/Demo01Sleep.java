package cn.itcast.day06.demo03;

/*
    public static void sleep(long millis) ：使当前正在执行的线程以指定毫秒数暂停（暂时停止执行）。
    毫秒数结束之后，线程继续执行
*/
public class Demo01Sleep {

    public static void main(String[] args) {
        // 模拟秒表
        for (int i = 0; i < 60; i++) {
            System.out.println(i);

            // 使用Thread类中的sleep方法让程序睡眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
