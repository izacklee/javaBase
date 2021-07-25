/*
强制类型转换
	1.特点：代码需要特殊处理，不能自动完成。
	2.格式：范围小的类型 范围小的变量 = （范围小的类型）原本范围大的数据；

注意事项：
	1.强制转换一般不推荐使用，因为有可能会发生精度损失，数据溢出。
	2.byte/short/char这三种类型都可以发生数学运算，例如加法“+”。
	3.byte/short/char这三种类型在运算的时候，都先提升为int型，然后再计算。
	4.boolean不能发生数据类型转换。
*/
public class Demo02DataType{
	public static void main(String[] args){
			//	左边是int类型，右边是long类型，不一样
			// long --> int,不是从小到大
			// 不能发生自动转换
			// 格式：范围小的类型 范围小的变量 = （范围小的类型）原本范围大的数据；
			int num = (int) 100L;
			System.out.println(num); // 100

			// long强制转换成int类型
			long num2 = (int) 6000000000L;
			System.out.println(num2); // 1705032704

			// double --> int 强制类型转换
			int num3 = (int) 3.15;
			System.out.println(num3); // 3

			// byte类型做数学运算
			byte b = 20;
			byte b1 = 30;
			// byte + byte --> int + int -->int
			int res = b + b1;
			System.out.println(res); // 50

			// short类型做数学运算
			short s = 50;
			// byte + short --> int + int -- int 
			// int强制转换成short:注意必须保证逻辑没问题，真实大小不超过short的范围，否则会造成数据溢出
			short res1 = (short) (b + s);
			System.out.println(res1); // 70

			// char类型字符变量做数学运算
			char c = 'A';
			System.out.println(c + 1); // 66，大写的A被当做65进行处理
			// 计算机的底层会用一个数字（二进制）来代表大写的A，也就是65
			// 一旦char类型进行了数学运算，那么字符A就会按照一定的规则转换成数字

	}
}