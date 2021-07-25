public class Demo17LoopHourAndMinute {
	public static void main(String[] args) {
		for (int hour = 0; hour < 24; hour++) { // 外层控制小时
			for (int minute = 0; minute < 60; minute++) { // 内层控制分
				System.out.println(hour + "小时" + minute + "分");
			}
		}
	}
}