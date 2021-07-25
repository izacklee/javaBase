/*
与 （并且） &&  全部都是true，才是true，否则为false。
或 （或者） ||  只要有一个true，就为true，全是false，才是false。
非 （非）   ！  本来是true，变成false，本来是false，变成true。

与“&&”，或“||”，具有短路效果，只要左边已经可以判断得到最终结果，那么右边将不会再执行，从而节省了一定的性能。

注意事项：
	1.逻辑运算符只能用于boolean值。
	2.与、或需要左右各有一个boolean值，但是非只要有一个boolean就行。
	3.与、或两种运算符，如果是多条件，可以连续写。
	两个条件：条件A && 条件B
	多个条件：条件A || 条件B || 条件C

TIPS:
	对于1 < x <3的情况，应该拆分成两个部分，然后用运算符连接起来。
	int x = 2;
	1 < x && x <3
*/

public class Demo09Logic{
	public static void main(String[] args){
		System.out.println(true && false); // false
		// true && true --> true
		System.out.println(1 < 2 && 10 > 5); // true

		System.out.println(true || false); // true
		System.out.println(false || false);  // false

		// &&的短路效果
		int num = 10;
		// false && ...
		// num < 2左边已经可以得到最终结果，右边++num < 12将不在执行
		System.out.println(num < 2 && ++num < 12); // false
		System.out.println(num); // 10

		// ||的短路效果
		int num1 = 20;
		// true || ...
		// 5 < num1左边已经可以得到最终结果，++num1 < 15右边将不在执行
		System.out.println(5 < num1 || ++num1 < 15); // true
		System.out.println(num1); // 20

	}
}