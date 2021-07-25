package cn.itcast.day01.junit;

/*
    Junit单元测试
        测试分类：
            1.黑盒测试：不需要写代码，给输入值，看程序是否能输出期望值
            2.白盒测试：需要写代码。关注程序的具体执行流程

        Java使用：白盒测试
            步骤：
                1.定义一个测试类（测试用例）
                    建议：
                        a.测试类名：被测试的类名Test   CalculatorTest
                        b.包名：xxx.xxx.xx.test    cn.itcast.day01.test
                2.定义测试方法：可独立运行
                    建议：
                        a.方法名：test测试的方法名
                        b.返回值：void
                        c.参数列表：空参
                3.给方法加@Test
                4.导入Junit的环境依赖
            判断结果：
                红色：失败
                绿色：成功
                一般我们会使用断言操作来处理结果
                    Assert.assertEquals(期望结果,运算的结果));
            补充：
                @Before：修饰的方法会在测试方法执行之前自动执行
                @After：修饰的方法会在测试方法执行之后自动执行
*/
public class CalculatorTest {

    public static void main(String[] args) {
        // 创建对象
        Calculator c = new Calculator();
        // 调用方法
        int total = c.add(1, 2);
        System.out.println(total); // 3

        System.out.println(c.sub(2, 1)); // 1
    }

}
