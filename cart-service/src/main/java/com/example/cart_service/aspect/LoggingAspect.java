package com.example.cart_service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.cart_service.service.CartService.*(..))")
    public void logBeforeService(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsString = Arrays.toString(args);
        log.info("Executing method: " + methodName + ", Arguments: " + argsString);
    }

    @AfterReturning(pointcut = "execution(* com.example.cart_service.service.CartService.*(..))", returning = "result")
    public void logAfterService(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsString = IntStream.range(0, args.length)
                .mapToObj(i -> {
                    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
                    Parameter parameter = method.getParameters()[i];
                    return parameter.getName() + "=" + args[i];
                })
                .collect(Collectors.joining(", "));
        log.info("Method executed: " + methodName + ", Arguments: " + argsString +", Return: " + result);
    }

}
