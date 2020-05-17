package com.spring.aop.main;

import com.spring.aop.config.Config;
import com.spring.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method
        accountDAO.addAccount();

        // close the context
        context.close();
    }
}
