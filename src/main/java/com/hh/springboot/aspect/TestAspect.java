package com.hh.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 切面类
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/3/10
 */
@Aspect
@Configuration
@Order(1)  // 控制切面类运行顺序，数字越小顺序越大
public class TestAspect {
    @Around("within(com.hh.springboot.handler.*Handler)")
    public Object around0(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始。。。。0");
        System.out.println("目标方法名称0:" + proceedingJoinPoint.getSignature().getName());
        System.out.println("目标方法参数0:" + proceedingJoinPoint.getArgs());
        System.out.println("目标方法对象0:" + proceedingJoinPoint.getTarget());
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕结束0。。。。");
        return proceed;
    }

    @Before("within(com.hh.springboot.handler.*Handler)")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知。。。。");
        System.out.println("目标方法名称:" + joinPoint.getSignature().getName());
        System.out.println("目标方法参数:" + joinPoint.getArgs());
        System.out.println("目标方法对象:" + joinPoint.getTarget());
    }

    @After("within(com.hh.springboot.handler.*Handler)")
    public void after(JoinPoint joinPoint) {
        System.out.println("后置通知。。。。");
        System.out.println("目标方法名称:" + joinPoint.getSignature().getName());
        System.out.println("目标方法参数:" + joinPoint.getArgs());
        System.out.println("目标方法对象:" + joinPoint.getTarget());

    }
}
