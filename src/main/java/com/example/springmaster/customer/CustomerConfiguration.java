package com.example.springmaster.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    // if we wanna do setup when app starts
    // maybe add sth to the db as soon as app starts
    // like a seed script??
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> System.out.println("CommandLineRunner");
    }

    // tell it to instantiate whether fake or real repo
    @Bean
    ICustomerRepo customerRepo(){
        System.out.println("useCustomerFakeRepository = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository() :
                new CustomerRepository();
    }
}
