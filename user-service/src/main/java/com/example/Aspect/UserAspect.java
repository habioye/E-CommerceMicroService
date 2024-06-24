package org.example.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class UserAspect {
    // Controller before and after
    @Before("execution(* org.example.Controller.UserController.*(..))")
    public void logBeforeBlog(JoinPoint joinPoint){
        log.info("Method:{}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* org.example.Controller.UserController.*(..))", returning = "res")
    public void logAfterBlog(JoinPoint joinPoint, Object res){
        log.info("Method:{} Returning:{}", (joinPoint.getSignature().getName()),res);
    }

    // Service before and after
    @Before("execution(* org.example.Service.UserService.*(..))")
    public void logBeforeBlog(JoinPoint joinPoint){
        log.info("Method:{}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* org.example.Service.UserService.*(..))", returning = "res")
    public void logAfterBlog(JoinPoint joinPoint, Object res){
        log.info("Method:{} Returning:{}", (joinPoint.getSignature().getName()),res);
    }
}
