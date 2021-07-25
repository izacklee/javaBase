package cn.itcast.day08.demo02;

/*
分割字符串的方法：

public String[] split(String regex)：按照参数的规则，将字符串分成若干部分。

注意事项：
    split：方法的参数其实是一个“正则表达式”，今后学习。
    今天要注意：如果按英文句点“.”进行分割，必须写“\\.”（两个反斜杠）
*/
public class Demo05StringSplit {
    public static void main(String[] args) {
        // 将字符串拆分成数组
        String str1 = "abc,def,hij";
        String[] resultStr = str1.split(",");
        for (int i = 0; i < resultStr.length; i++) {
            String res = resultStr[i];
            System.out.println(res);
        }
        System.out.println("============");

        String str2 = "aaa.bbb.ccc";
//        String[] resultStr1 = str2.split("."); // 错误写法！英文句点前要加两个反斜杠
//        System.out.println(resultStr1.length); // 0
        String[] resultStr1 = str2.split("\\.");
        for (int i = 0; i < resultStr1.length; i++) {
            System.out.println(resultStr1[i]);
        }
    }
}
