package cn.itcast.day07.demo04;

/*
定义一个数组，用来存储3个Person对象

数组有一个缺点：一旦创建，程序运行期间不可发生改变。
*/
public class Demo01Array {
    public static void main(String[] args) {
        // 首先创建一个长度为3的数组,里面用来存储Person类型对象
        Person[] array = new Person[3];
        Person one = new Person("高圆圆", 20);
        Person two = new Person("赵又廷", 18);
        Person three = new Person("迪丽热巴",26);

        // 将Person创建出来的3个对象分别存入到对应索引的数组里
        array[0] = one;
        array[1] = two;
        array[2] = three;

        System.out.println(array[0]); //5fe5c6f 地址值
        System.out.println(array[1]); //6979e8cb 地址值
        System.out.println(array[2]); //763d9750 地址值

        System.out.println(array[1].getName()); // 赵又廷
    }
}
