package com.example.aop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Slf4j
@Component
//@Aspect
public class MyAspect5 {

    //前置通知

    //@Before("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")

    //@Before("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")

    //@Before("execution(void delete(java.lang.Integer))") //包名.类名 强烈不建议省略

    //@Before("execution(* com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")

    //@Before("execution(* com.*.service.impl.DeptServiceImpl.delete(java.lang.Integer))")

    //@Before("execution(* com.itheima.service.impl.*.delete(java.lang.Integer))")

    //@Before("execution(* com.itheima.service.impl.*.*(java.lang.Integer))")

    //@Before("execution(* com.itheima.service.impl.*.*(*))")

    //@Before("execution(* com.itheima.service.impl.*.del*(*) )")

    //@Before("execution(* com.itheima.service.impl.*.*(..))")

    //@Before("execution(* com..service.impl.DeptServiceImpl.*(..))")

    //@Before("execution(* com.itheima.service..*(..))")
//    @Before("execution(* com.itheima.service..*(..))")

    //匹配

    @Before( "execution(* com.example.service.DeptService.list(..) ||"  +
            "execution(* com.example.service.DeptService.delete(..)")
    public void before() {
        log.info("MyAspect5 -> before ...");
    }

}