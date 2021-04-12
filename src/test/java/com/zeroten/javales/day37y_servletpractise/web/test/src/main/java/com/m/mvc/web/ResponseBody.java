package com.m.mvc.web;

import java.lang.annotation.*;

@Documented // 加上有注解的地方javac才会编译，默认是不编译的
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseBody {
}
