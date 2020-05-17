package com.spring.aop.ascpect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // declaring a pointcut
    @Pointcut("execution(* com.spring.aop.dao.*.*(..))")
    private void forDaoPackage() {}

    // add related advices for logging

    // () - matches a method with no arguments
    // (*) - matches a method with one argument of any type
    // (..) - matches a method with one ore more arguments of any type

    // @Before("execution(public void com.spring.aop.dao.AccountDAO.addAccount())")
    @Before("execution(void add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====> Executing @Before advice on add*()");
    }

    @Before("execution(* com.spring.aop.dao.MembershipDAO.add*())")
    public void beforeAddAccountMembership() {

        System.out.println("\n=====> Executing @Before advice on addAcccount() for MembershipDAO");
    }

    @Before("execution(* add*(com.spring.aop.domain.Account, ..))")
    public void beforeAccountWithParam() {

        System.out.println("\n=====> Add* method with (Account obj, ..))");
    }

    @Before("forDaoPackage()")
    public void anyClassAndMethod() {

        System.out.println("\n=====> Before any method in the dao package");
    }

}
