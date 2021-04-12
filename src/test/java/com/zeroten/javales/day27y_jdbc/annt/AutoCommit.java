package com.zeroten.javales.day27y_jdbc.annt;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoCommit {
    public boolean value() default true;
}
