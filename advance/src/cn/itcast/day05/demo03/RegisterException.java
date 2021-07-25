package cn.itcast.day05.demo03;


/*
    自定义异常的类：
        java提供的异常类，不够我们使用，需要自己定义一些异常类
    格式：
        public class XXXException extends Exception / RuntimeException {
            // 添加一个空参构造方法
            // 添加一个带异常信息的构造方法
        }
     注意：
        1.自定义异常类一般都是Exception结尾，说明该类是一个异常类
        2.自定义异常类，必须继承Exception或者RuntimeException
            继承Exception：那么自定义的异常类就是一个编译期异常类，如果方法抛出了异常，就必须处理这个异常，
                          要么throws，要么try...catch
            继承RuntimeException：那么自定义的异常类就是一个运行期异常类，无需处理，交给JVM处理
*/
public class RegisterException extends /*Exception*/ RuntimeException{

    // 空参构造方法
    public RegisterException() {
        super();
    }

    // 带异常信息的构造方法
    // 查源码发现，该构造方法可以直接把异常信息传给父类构造方法，让父类来处理
    public RegisterException(String message) {
        super(message);
    }
}
