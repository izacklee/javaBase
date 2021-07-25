/*
三种循环的区别：
	1.如果条件从来没有被满足过，那么for和while循环将会执行0次，而do-while循环至少会执行1次。
	2.for循环的变量在小括号里定义，那么只能在循环内部使用，而while和do-while循环变量是在循环外部定义，所以循环之后还可以继续使用。
*/

public class Demo13LoopDifference {
	public static void main(String[] args) {
		for (int i = 1; i < 0; i++) {
			System.out.println("大家");
		}

		int i = 1;
		do {
			System.out.println("好");
			i++;
		} while (i < 0);
		System.out.println(i); // 2
	}
}