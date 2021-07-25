/*
do-while循环

标准格式：
	do {
		循环体
	} while (判断条件);

扩展格式：
	初始化语句1
	do {
		循环体3
		步进语句4
	} while (条件判断2);

注意事项：
	1.即便判断条件不成立，也至少会执行一次do大括号里的循环体和步进语句。
*/
	public class Demo11DoWhile {
		public static void main(String[] args) {

			int i = 11; // 初始化语句1
			do {
				System.out.println("我们一起玩" + i);  // 循环体3
				i++; // 步进语句 4
			} while (i <= 10); // 条件判断2
			System.out.println(i); // 12
		}
	}