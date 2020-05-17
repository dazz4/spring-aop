package com.spring.aop.dao;
import com.spring.aop.domain.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean isFlagged) {

        System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public List<Account> findAccounts(boolean flag) {

        if (flag) {
            throw new RuntimeException("No accounts found");
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John", "Silver"));
        accounts.add(new Account("Luke", "Platinium"));

        return accounts;
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": inGetName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": inSetName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": inGetServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": inSetServiceCode");
        this.serviceCode = serviceCode;
    }
}
