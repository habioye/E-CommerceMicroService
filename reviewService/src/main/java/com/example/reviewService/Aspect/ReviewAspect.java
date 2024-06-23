package com.example.reviewService.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ReviewAspect {
    @Before("execution(* com.example.reviewService.Service.ReviewServiceImpl.*(..))")
    public void logBeforeBlog(JoinPoint joinPoint){
        log.info("Method:{}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.reviewService.Service.ReviewServiceImpl.*(..))", returning = "res")
    public void logAfterBlog(JoinPoint joinPoint, Object res){
        log.info("Method:{} Returning:{}", (joinPoint.getSignature().getName()),res);
    }
}
