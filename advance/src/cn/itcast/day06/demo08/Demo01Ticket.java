package cn.itcast.day06.demo08;

/*
    卖票案例出现了线程的安全问题
    卖出了不存在的或者重复的票

    解决线程安全问题的第二种方案：使用同步方法
    使用步骤：
        1.把访问了共享数据的代码抽取出来，放到一个方法中
        2.在方法上添加synchronized修饰符
    格式：
        修饰符 synchronized 返回值类型 方法名称(参数列表) {
            可能会出现线程安全问题的代码（访问了共享数据的代码）
        }
*/
public class Demo01Ticket {

    public static void main(String[] args) {
        RunnableImpl r = new RunnableImpl();
        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        // 3线程 同时开启
        t0.start();
        t1.start();
        t2.start();
    }

}
