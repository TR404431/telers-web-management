package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 连接点
 */
//@Aspect
@Component
@Slf4j
public class MyAspect6 {


    // 环绕通知
    @Around("execution(* com.itheima.service.DeptService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getTarget().getClass().getName(); 
        // 获取目标类名

        Signature signature = joinPoint.getSignature(); 
        // 获取目标方法签名

        String methodName = joinPoint.getSignature().getName(); 
        // 获取目标方法名

        Object[] args = joinPoint.getArgs(); 
        // 获取目标方法运行参数


        Object res = joinPoint.proceed(); 
        // 执行原始方法，获取返回值（环绕通知）


        return res;
    }


    // 其它通知
    @Before("execution(* com.itheima.service.DeptService.*(..))")
    public void before(JoinPoint joinPoint) {

        String className = joinPoint.getTarget().getClass().getName(); 
        // 获取目标类名

        Signature signature = joinPoint.getSignature(); 
        // 获取目标方法签名

        String methodName = joinPoint.getSignature().getName(); 
        // 获取目标方法名

        Object[] args = joinPoint.getArgs(); 
        // 获取目标方法运行参数

    }

}