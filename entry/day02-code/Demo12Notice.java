/*
对于byte/short/char三类型来说，如果右侧的数值没有超过范围，
那么javac编译器将会自动隐含地为我们补上一个(byte)(short)(char)。

1.如果没有超过左侧范围，编译器补上强转。
2.如果右侧超过左侧范围，那么编译器就会报错。
*/

public class Demo12Notice{
	public static void main(String[] args){
		// 右侧确实是一个int数字，但是并没有超过左侧，正确。
		// int --> byte ,不是自动类型转换（因为范围不是从小到大）
		byte num1 = /* (byte) */ 10;
		System.out.println(num1); // 10

		// byte num2 =128 //右侧超过左侧范围

		// int --> char，没有超过范围
		// 编译器会主动补上一个隐藏的char
		char zifu = /* (char) */ 65;
		System.out.println(zifu); // A
	}
}