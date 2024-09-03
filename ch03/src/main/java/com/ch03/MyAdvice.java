package com.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //부가기능을 aspect로
@Component //부가기능
public class MyAdvice {

    //포인트컷 정의

    @Pointcut("execution(void com.ch03.MyService.insert())") //문법
    public void insertPointcut(){} // 핵심관심을 가리키는 내용이 없는 메서드

    @Pointcut("execution(void com.ch03.MyService.select(..))")
    public void selectPointcut(){}

    //시점 부여
    @Before("insertPointcut() || selectPointcut()")
    public void beforeAdvice(){
        System.out.println("부가기능 - beforeAdvice");
    }
    @After("insertPointcut()")
    public void afterAdvice(){
        System.out.println("부가기능 - afterAdvice");
    }
    @AfterReturning("insertPointcut()")
    public void afterReturningAdvice(){
        System.out.println("부가기능 - afterReturnAdvice");
    }
    @Around("insertPointcut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable { //pjp로 핵심관심 모듈이 들어옴

        System.out.println("부가기능 - aroundAdvice1");
        pjp.proceed(); // 핵심관심 + throw 선언
        System.out.println("부가기능 - aroundAdvice2");
    }
    //예외가 발생했을 때 실행
    @AfterThrowing("selectPointcut()")
    public void afterThrowAdvice(){
        System.out.println("부가기능 - afterThrowAdvice");
    }
}
