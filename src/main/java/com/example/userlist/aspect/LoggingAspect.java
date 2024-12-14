package com.example.userlist.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore() {
        logger.info("Метод выполнится...");
    }


    @AfterReturning("execution(* com.example.service.*.*(..))")
    public void logAfterReturning() {
        logger.info("Метод успешно завершен.");
    }


    @AfterThrowing("execution(* com.example.service.*.*(..))")
    public void logAfterThrowing() {
        logger.error("Произошла ошибка при выполнении метода.");
    }
}
