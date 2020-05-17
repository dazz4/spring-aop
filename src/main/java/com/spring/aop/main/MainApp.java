package com.spring.aop.main;

import com.spring.aop.config.Config;
import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;
import com.spring.aop.domain.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        accountDAO.addAccount(new Account("Dazz's account", "silver"), true);

        // call accountDAO getter/setter methods
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        accountDAO.getName();
        accountDAO.getServiceCode();

        List<Account> accounts = null;

        // call method to find account
        try {
            accounts = accountDAO.findAccounts(true);
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("\n\nMain Program ... caught exception: " + e);
        }


        // close the context
        context.close();
    }
}
