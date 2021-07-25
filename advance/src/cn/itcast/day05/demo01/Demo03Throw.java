package cn.itcast.day05.demo01;

/*
    Throw关键字
    作用：
        可以使用throw关键字在指定的方法中抛出指定异常
    使用格式：
        throw new xxxException("异常产生的原因");
    注意：
        1.throw关键字必须写在方法内部
        2.throw关键字后边的对象必须是Exception或者Exception的子类对象
        3.throw关键字抛出指定的异常对象，我们就必须处理这个异常对象
            throw关键字后边创建的是RuntimeException或者是RuntimeException的子类对象，我们可以不处理，
            默认交给JVM处理（打印异常对象，中断程序）
            throw关键字后边创建的是编译异常（写代码的时候报错），我们就必须处理这个异常，要么throws，要么try...catch

    提示：以后（工作中）我们首先必须对方法传递过来的参数进行合法性效验，
         如果参数不合法，那么我们就必须使用抛出异常的方式，告知方法的调用者，传递的参数有问题
*/
public class Demo03Throw {

    public static void main(String[] args) {
//        int[] arr = null; // java.lang.NullPointerException: 参数数组为null值  运行期异常不需要处理，交给JVM处理
        int[] arr = {1, 2, 3};
        int res = getElement(arr, 0);

        System.out.println(res);
    }

    /*
      获取数组指定索引处的元素
    */
    public static int getElement(int[] arr, int index) {
        // 判断数组是否为null值
        if (arr == null) {
            throw new NullPointerException("参数数组为null值");
        }

        // 判断参数索引长度是否超出范围
        if (index < 0 || index > arr.length-1) {
            throw new IndexOutOfBoundsException("参数索引长度超出范围");
        }

        int in = arr[index];
        return in;
    }
}
