package com.spring.aop.ascpect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // add related advices for logging
    @Before("execution(public void com.spring.aop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====> Executing @Before advice on addAcccount()");

    }

    @Before("execution(* com.spring.aop.dao.MembershipDAO.add*())")
    public void beforeAddAccountMembership() {

        System.out.println("\n=====> Executing @Before advice on addAcccount() for MembershipDAO");


    }
}
