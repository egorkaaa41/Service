package ru.atom.lecture07.server.SPRING_AOP;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("within(ru.atom.lecture07.server.controller.Rest_APIController)")
    public void stringProcessingMethods() {};

    @After("stringProcessingMethods()")
    public void logMethodCall(JoinPoint jp) {

        String methodName = jp.getSignature().getName();
        logger.log(Level.INFO, "название метода: " + methodName);
    }

    @AfterReturning(pointcut = "stringProcessingMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        logger.log(Level.INFO, "возвращенное значение: " + result.toString());
    }

}
