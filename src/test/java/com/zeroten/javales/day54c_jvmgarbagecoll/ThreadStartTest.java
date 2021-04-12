package src.test.java.com.zeroten.javales.day54c_jvmgarbagecoll;

/*
* 线程start测试
*/
public class ThreadStartTest {

    public static void main(String[] agrs) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(true) {
                    System.out.println("1");

//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        });

        for (int i=0; i<10; i++) {
            // 线程返回code -1 是被外界强制终止掉（有钩子方法不会执行），返回0才是正常停止（有钩子方法会执行）
            thread.start();  // 结果只能打印一次 然后报java.lang.IllegalThreadStateException

        }
    }
}
