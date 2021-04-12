package com.m.test3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 增强类
@Aspect
@Component  // 相当于在配置文件里写了个bean
@Scope("prototype")
public class BaseAdvice {
    
    // 切入点
    @Pointcut("execution(public * com.m.test3.service.impl.*.*(..))")
    public void myPointcut() {
        
    }
    
    // JoinPoint 连接点
    @Before("myPointcut()")
    public void beforeService(JoinPoint joinPoint) {
        
    }
    
    @After("myPointcut()")
    public void afterService(JoinPoint joinPoint) {
        
    }
    
    @Around("myPointcut()")
    public Object aroundService(ProceedingJoinPoint joinPoint) {
        System.out.println("1 开启连接");
        System.out.println("2 开启事务");
        
        Object result = null;
        try {
            // 1 获取目标对象实现类，该实现类有父类，父类当中有连接对象，使用反射给连接对象赋值
            // 2 把连接对象以参数方式，传递给dao的参数
            // 3 dao不需要实现类，直接在这里，使用动态代理来完成dao的操作
            result = joinPoint.proceed(new Object[]{"连接对象"});
            System.out.println("4 SQL提交");
        } catch (Throwable throwable) {
            System.out.println("5 SQL的回滚");
            throwable.printStackTrace();
        } finally {
            System.out.println("6 SQL关闭");
        }
        return result;
    }
    
    @AfterReturning(value="myPointcut()", returning="name" )
    public void returnService(JoinPoint joinPoint, Object name) {
        
    }
    
    @AfterThrowing(value="myPointcut()", throwing="ex")
    public void exceptionService(JoinPoint joinPoint, Throwable ex) {
        
    }
}
