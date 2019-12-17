package com.zeroten.javales.flow;

import org.testng.annotations.Test;

public class CodeBlock {

    @Test
    public void testBlockScope() {
        int n1 = 100;
        System.out.println(n1); // 100

        // 代码块
        {
            int n2 = 200;
            n1 = n2;
            System.out.println(n1); // 200
            System.out.println(n2); // 200

            {
                System.out.println(n2); // 200
            }
        }

        System.out.println(n1); // 200
    }
}
