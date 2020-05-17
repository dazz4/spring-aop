package com.spring.aop.ascpect;

import com.spring.aop.domain.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @AfterReturning(
            pointcut = "execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n=====> Executing @AfterReturning on method: " + method);
        System.out.println("\n=====> result is: " + result);

    }
}
