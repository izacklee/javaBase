package src.test.java.com.zeroten.javales.day54c_jvmgarbagecoll;

/*
* 造成cpu100%的例子
*/
public class Cpu100 {

    public static void main(String[] args) {

        // 获取cpu的核心数
        int cpuCores = Runtime.getRuntime().availableProcessors();

        // 让所有cpu都占满
        for (int i=0; i<cpuCores; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

//                        Thread.sleep(1);  // 会造成cpu打满问题

                    }
                }
            }, "thread" + (i+1)).start();
        }

        // 开启10个业务线程
        int bizThreadCount = 10;

        for (int i=0; i<bizThreadCount; i++) {

            new Thread(new Runnable() {

                @Override
                public void run() {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "is running");
                }

            }, "bizThread" + (i+1)).start();

        }

    }

}
