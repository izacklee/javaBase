package com.zeroten.javales.day27y_jdbc.annt;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Join {
    public String fk();
    public String table();
    public String className() default "";
}

