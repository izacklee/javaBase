/*
另一种循环控制语句continue关键字。
一旦执行，就会跳过当前循环剩下的内容，马上开始下一次循环。
*/

public class Demo15Continue {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			// 如果当前是第4层
			if (i == 4) {
				continue; // 跳过当前层数，马上开始下一层（第5层）；
			}
			System.out.println(i + "层到了。");
		}
	}
}