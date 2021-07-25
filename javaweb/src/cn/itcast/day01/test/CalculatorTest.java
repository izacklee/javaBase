package cn.itcast.day01.test;

import cn.itcast.day01.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /*
        初始化方法
            用于资源申请，所有方法在执行之前都会先执行该方法
    */
    @Before
    public void init() {
        System.out.println("init....");
    }

    /*
        释放资源方法
            在所有测试方法执行后，都会自动执行该方法
    */
    @After
    public void close() {
        System.out.println("close...");
    }

    /*
        测试add方法
    */
    @Test
    public void teatAdd() {
        System.out.println("我被执行了！"); // 我被执行了！
        // 创建对象
        Calculator c = new Calculator();
        // 调用方法
        int total = c.add(2, 3);
        System.out.println(total); // 5

        // 断言（可根据断言返回红色或者绿色） 我断言这个结果是3
        Assert.assertEquals(5,total); // 返回红色 说明方法优异常

    }

    @Test
    public void testSub() {
        // 创建对象
        Calculator c = new Calculator();
        // 调用方法
        int result = c.sub(2, 3);
        System.out.println(result);
        // 断言
        Assert.assertEquals(-1,result); // 绿色 正确

    }}
