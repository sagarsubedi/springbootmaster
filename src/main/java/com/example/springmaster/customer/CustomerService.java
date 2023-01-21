// this is the Service Layer. Client -> Controller -> Service -> DAO
package com.example.springmaster.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // being specific and says this is meant to be a service
// @Component
// creates a bean that we can inject in multiple places . ComputerService is a singleton so we get same
// instance instead of multiple
public class CustomerService {

    // Repository Dependency injection needed
    private final ICustomerRepo customerRepo;

    @Autowired
    public CustomerService(ICustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }

}
