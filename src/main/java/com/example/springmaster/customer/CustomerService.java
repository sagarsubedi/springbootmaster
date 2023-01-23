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
    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Customer with id %d not found.", id)));
    }

}
