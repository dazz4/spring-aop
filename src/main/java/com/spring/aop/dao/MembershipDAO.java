package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(": DOING MY DB WORK: ADDING AN ACCOUNT FOR MEMBERSHIP");
    }
}
