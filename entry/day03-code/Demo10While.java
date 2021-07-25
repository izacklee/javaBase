/*
while循环有一个标准的格式，还有一个扩展的格式：

标准格式：
	while(条件判断){
		循环体
	}

扩展格式:
	
	初始化语句;
	while(条件判断){
		循环体;
		步进语句;
	}
*/
public class Demo10While{
	public static void main(String[] args){
		// 标准格式 -- 死循环
		// while(true){
		// 	System.out.println("while的标准格式");
		// }

		// 扩展格式
		int b = 1; // 1. 初始化语句
		while(b <= 10){ // 2. 条件判断语句
			System.out.println("while的扩展格式" + b); // 3. 循环体
			b++; // 4. 步进语句
		}

		// 学生成绩查询例子
		/*String flag = "y";
		while (flag.equals("y")) {
			System.out.println("请输入要查询的学生的学号：");
			Scanner s = new Scanner(System.in);
			int id = s.nextInt();
			switch (id) {
				case 1:
					System.out.println("胡歌的成绩：99分");
					break;
				case 2:
					System.out.println("迪丽热巴的成绩:98分");
					break;
				default:
					System.out.println("学号输入有误！");
			}
			System.out.println("是否还要继续查询？y/n");
			flag = s.next();
		}
		System.out.println("本次查询结束！");*/

		// 体能测试题
		/*Scanner s = new Scanner(System.in);
		String flag = "n";
		while (flag.equals("n")) {
			System.out.println("江疏影跑1000米体能测试！！！");
			System.out.println("是否合格？y/n");
			flag = s.next();
		}
		System.out.println("合格，通过测试!");*/


	}
}