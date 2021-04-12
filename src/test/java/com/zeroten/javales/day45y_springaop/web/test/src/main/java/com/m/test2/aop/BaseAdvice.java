package com.m.test2.aop;

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
    @Pointcut("execution(public * com.m.test2.service.impl.*.*(..))")
    public void myPointcut() {
        
    }
    
    // JoinPoint 连接点
    @Before("myPointcut()")
    public void beforeService(JoinPoint joinPoint) {
        System.out.println("前置增强");
        System.out.println("beforeService连接点对象：" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("beforeService连接点的方法：" + joinPoint.getSignature());
        System.out.println("beforeService连接点方法参数：" + joinPoint.getArgs()[0]);

        // 接下来可通过 --- 反射操作
    }
    
    @After("myPointcut()")
    public void afterService(JoinPoint joinPoint) {
        System.out.println("后置增强");
        System.out.println("afterService连接点对象：" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("afterService连接点的方法：" + joinPoint.getSignature());
        System.out.println("afterService连接点方法参数：" + joinPoint.getArgs()[0]);
    }
    
    @Around("myPointcut()")
    public Object aroundService(ProceedingJoinPoint joinPoint) {

        System.out.println("aroundService连接点对象：" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("aroundService连接点的方法：" + joinPoint.getSignature());
        System.out.println("aroundService连接点方法参数：" + joinPoint.getArgs()[0]);

        // 这个proceed有个重载 如果是默认传进来的实参
        try {
            System.out.println("环绕增强前");
            Object result = joinPoint.proceed();   // 默认传进来的实参用
//        joinPoint.proceed(args);  // 默认传进来的要修改实参用
            System.out.println("环绕增强后");
            
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
    
    @AfterReturning(value="myPointcut()", returning="name" )
    public void returnService(JoinPoint joinPoint, Object name) {
        System.out.println("产生返回值");
        System.out.println("returnService连接点对象：" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("returnService连接点的方法：" + joinPoint.getSignature());
        System.out.println("returnService连接点方法参数：" + joinPoint.getArgs()[0]);
    }
    
    @AfterThrowing(value="myPointcut()", throwing="ex")
    public void exceptionService(JoinPoint joinPoint, Throwable ex) {
        System.out.println("产生异常");
        System.out.println("exceptionService连接点对象：" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("exceptionService连接点的方法：" + joinPoint.getSignature());
        System.out.println("exceptionService连接点方法参数：" + joinPoint.getArgs()[0]);
    }
}
