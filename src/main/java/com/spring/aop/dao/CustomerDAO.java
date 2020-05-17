package com.spring.aop.dao;
import com.spring.aop.domain.Customer;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class CustomerDAO {
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Dazz", "Kaminski"));
        customers.add(new Customer("John", "Walker"));

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
