package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//限制这个注解只能标注在方法上。
@Target(ElementType.METHOD)
//运行时仍然存在。
@Retention(RetentionPolicy.RUNTIME)
/**
 1. 编写自定义注解
 2. 在业务类要做为连接点的方法上添加自定义注解
 **/
public @interface LogOperation{
}