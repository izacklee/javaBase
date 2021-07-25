/*
在给变量赋值的时候，右侧表达式中全是常量，没有变量，
那么编译器javac将会直接将若干个表达式计算得到结果。
short result = 5 + 10; // 等号右边全是常量，没有任何变量参与运算
编译之后得到.class字节码文件当中相当于【直接就是】：
short result = 13;
右侧常量结果的数值，没有超过左侧范围，正确。

这称为"编译器的常量优化"。

但是注意：一但表达式当中有变量参与，那就不进行这种优化了。
*/

public class Demo13Notice{
	public static void main(String[] args){
		short num1 = 12; // 正确，右侧没超过左侧范围

		short a = 2;
		short b = 3;
		// short + short --> int + int --> int
		// short result = a + b; // 错误写法，左侧需要int类型

		short result2 = 2 + 3;
		System.out.println(result2); // 5

	    // short result3 = 2 + a + 3; // 错误写法，表达式中有变量参与了
	}
}