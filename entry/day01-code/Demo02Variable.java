/*
变量：程序运行期间，内容可以发生改变的量

创建一个变量使用的格式：

数据类型 变量名称； //创建了一个变量
变量名称 = 数据值;  //赋值，将右边的数据值，赋值给左边的变量

一步到位的格式

数据类型 变量名称 = 数据值; //在创建变量的同时立刻放入指定的数据值
*/

public class Demo02Variable{
	public static void main(String[] args){
		//创建一个变量
		//格式：数据类型 变量名称;
		int num;
		num = 100; //定义的变量必须赋值才能用，否则报错
		System.out.println(num); //100

		//格式：数据类型 变量名称=数据值;
		int num1=200;
		System.out.println(num1); //200

		//定义字节变量
		byte b = 127; //右侧赋值不能超过左边定义的数据类型取值范围
		System.out.println(b);

		//定义短整型变量
		short s = 12345;
		System.out.println(s);

		//定义整型变量
		int i = 123456789;
		System.out.println(i);

		//定义长整型变量
		long l = 1234567890L;
		System.out.println(l);

		//定义单精度浮点型变量
		float f = 3.14F;
		System.out.println(f);

		//定义双精度浮点型变量
		double d = 3.1415;
		System.out.println(d);

		//定义字符型变量
		char c = 'A';
		System.out.println(c);

		//定义布尔型变量
		boolean bool = false;
		System.out.println(bool);
	}
}