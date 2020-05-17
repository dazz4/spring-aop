package com.spring.aop.ascpect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

    @Before("com.spring.aop.ascpect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {

        System.out.println("\n=====> Loggin to Cloud in async fashion");
    }

}
