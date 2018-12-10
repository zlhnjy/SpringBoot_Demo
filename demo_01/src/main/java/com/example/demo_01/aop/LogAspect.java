package com.example.demo_01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //声明一个切面
@Component  //
public class LogAspect {

    @Pointcut("@annotation(com.example.demo_01.aop.Action)")   //声明切点
    public void annotationPointCut(){

    }

    @After("annotationPointCut()")  //声明一个建言，使用定义的切点
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截：" + action.name());
    }

    @Before("execution(* com.example.demo_01.aop.DemoMethodService.*(..))")  //声明建言，使用拦截规则
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法规则拦截：" + method.getName());
    }

}
