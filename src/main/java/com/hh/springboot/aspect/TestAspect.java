package com.hh.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/3/10
 */
@Aspect
@Configuration
public class TestAspect {

    @Before("within(com.hh.springboot.handler.*Handler)")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置条件。。。。");
        System.out.println("目标方法名称:" + joinPoint.getSignature().getName());
        System.out.println("目标方法参数:" + joinPoint.getArgs());
        System.out.println("目标方法对象:" + joinPoint.getTarget());
    }
}
