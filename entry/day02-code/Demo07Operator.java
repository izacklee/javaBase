/*
赋值运算符分为：

基本赋值运算符：就是一个“=”，代表将右侧的数据交给左侧的变量。
	int a = 30;

复合赋值运算符：
	+=		a += 1    相当于 	a = a + 1
	-=      b -= 2    相当于 	b = b - 2
	*=      c *= 3    相当于     c = c * 3
	/=      d /= 4    相当于     d = d / 4
	%=      e %= 5    相当于     e = e % 5

注意事项：
	1.只有变量才能使用赋值运算符，常量不能赋值。
	2.复合运算符中隐含了一个强制类型转换。

*/

public class Demo07Operator{
	public static void main(String[] args){
		int a = 2;
		// 按照公式进行翻译 a = a + 3
		// a = 2 + 3;
		// a = 5;
		// a本来是2，现在重新赋值得到5
		a +=3;
		System.out.println(a); // 5

		int b = 5;
		// 按照公式翻译 b = b % 3;
		// b = 5 % 3;
		// b = 2;
		// b本来是5，现在重新赋值得到2
		b %= 3;
		System.out.println(b); // 2

		// 20 = 10 // 常量不能进行赋值，不能写在赋值运算的左边。错误！

		int x = 126;
		// x = x + 1
		// x = byte + int
		// x = int + int
		// x = int
		// x = (byte) int
		x += 1;

		// x += 30;  // 30相加后为156，结果大于左侧数据类型，造成数据溢出，错误！
		System.out.println(x); // 127
	}
}