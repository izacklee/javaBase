package com.zeroten.javales.day27y_jdbc.annt;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE) // 注解的作用域
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    public String value() default "";
}
