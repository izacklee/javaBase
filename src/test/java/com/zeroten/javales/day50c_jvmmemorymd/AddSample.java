package src.test.java.com.zeroten.javales.day50c_jvmmemorymd;

/**
 * @Description 相加测试
 */
public class AddSample {

    private volatile Integer count = 0;  // volatile无效 因为下面add方法里的count++ 不具有原子性
    private Object locker = new Object();

    public void add() {
//        count++;
        // 修改后 （正常是关键的部分加锁，不直接加载方法上）
        synchronized(locker) {
            count++;
        }
    }

    public static void main(String[] args) {
        final AddSample addSample = new AddSample();

        // 正常不建议这么写 应该是写一个线程循环1000次
        // 注：线程不能乱用，像这样重运算的操作，效率低
        // （因线程重复切换，cpu得不到充分利用。想提高效率，其实就是让cpu不停歇的运作（如io 读写数据库等））
        for (int i=0; i<100; i++) {
            new Thread(()->{
                for (int j=0; j<10; j++) {
                    addSample.add();
                }
            }).start();
        }

        /**
         * 如果还有子线程在运行，主线程就让出CPU资源
         * 直到所有的子线程都运行完了，主线程再继续往下执行
         */
        while(Thread.activeCount() > 1) {  // 让启动的100个线程都结束执行
            Thread.yield(); //  暂停当前正在执行的线程对象,并执行其他线程。
        }

        System.out.println(addSample.count); // 正确值：1000
    }

}
