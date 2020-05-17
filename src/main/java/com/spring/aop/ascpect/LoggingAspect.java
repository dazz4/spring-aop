package com.spring.aop.ascpect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // add related advices for logging
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====> Executing @Before advice on addAcccount()");
    }
}
