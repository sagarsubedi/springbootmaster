// this is the Service Layer. Client -> Controller -> Service -> DAO
package com.example.springmaster.customer;

import com.example.springmaster.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    Customer getCustomer(Long id){
        return getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("Customer with id %d not found.", id)));
    }

}
