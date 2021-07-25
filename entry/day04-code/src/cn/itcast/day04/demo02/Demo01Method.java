package cn.itcast.day04.demo02;

/*
复习一下此前学习的方法基础入门知识：

定义格式：
    public static void 方法名称 {
        方法体
    }

 调用格式：
    方法名称();

注意事项：
    1.方法定义的先后顺序无所谓。
    2.不能在方法里嵌套方法。
    3.方法定义之后不会自动执行，如果想执行，需要调用。
 */
public class Demo01Method {
    public static void main(String[] args) {
        printMethod();
    }
    // 题目：输出一个长为20颗星(*)，宽为5颗星的长方体形状。
    public static void printMethod() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
