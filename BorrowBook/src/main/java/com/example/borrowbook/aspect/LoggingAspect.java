package com.example.borrowbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private int visitCount = 0;

    @After("execution(* com.example.borrowbook.service.BookService.*(..))")
    public void logBookStateChange(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        if (method.equals("increaseQuantity") || method.equals("decreaseQuantity")) {
            System.out.println("[LOG] Trạng thái sách thay đổi qua: " + method);
        }
    }

    @Before("execution(* com.example.borrowbook.controller..*(..))")
    public void countVisitor(JoinPoint joinPoint) {
        visitCount++;
        System.out.println("[LOG] Lượt truy cập #" + visitCount +
                " - Vào: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.example.borrowbook.service..*(..))", throwing = "ex")
    public void logException(JoinPoint jp, Exception ex) {
        System.out.println("[ERROR] " + jp.getSignature() + " -> " + ex.getMessage());
    }
}
