package com.spring.aop.ascpect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    // add related advices for logging

    // () - matches a method with no arguments
    // (*) - matches a method with one argument of any type
    // (..) - matches a method with one ore more arguments of any type

    // @Before("execution(public void com.spring.aop.dao.AccountDAO.addAccount())")

    @Before("com.spring.aop.ascpect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n=====> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // display method signature
        System.out.println("\nMethod: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        for (Object tempArgs : args) {
            System.out.println(tempArgs);
        }
    }

//    @Before("execution(* com.spring.aop.dao.MembershipDAO.add*())")
//    public void beforeAddAccountMembership() {
//
//        System.out.println("\n=====> Executing @Before advice on addAcccount() for MembershipDAO");
//    }
//
//    @Before("execution(* add*(com.spring.aop.domain.Account, ..))")
//    public void beforeAccountWithParam() {
//
//        System.out.println("\n=====> Add* method with (Account obj, ..))");
//    }
}
