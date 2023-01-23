package com.example.springmaster.customer;

import com.example.springmaster.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    // if we wanna do setup when app starts
    // maybe add sth to the db as soon as app starts
    // like a seed script??
    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){
        return args -> {
            System.out.println("CommandLineRunner");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(infoApp);
        };
    }

    // tell it to instantiate whether fake or real repo
//    @Bean
//    ICustomerRepo customerRepo(){
//        System.out.println("useCustomerFakeRepository = " + useFakeCustomerRepo);
//        return useFakeCustomerRepo ?
//                new CustomerFakeRepository() :
//                new ICustomerRepository();
//    }
}
