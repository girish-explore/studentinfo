package com.company.usecase.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AopConfig {

    @Before("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut(JoinPoint joinPoint) {

        log.debug("Executed for the before the method, class gets executed ", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().getCanonicalName());
    }

}
