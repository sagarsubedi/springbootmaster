// this is the Service Layer. Client -> Controller -> Service -> DAO
package com.example.springmaster.customer;

import com.example.springmaster.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@AllArgsConstructor
@Slf4j
public class CustomerService {

//    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    // Repository Dependency injection needed
    private final ICustomerRepository customerRepository;

    List<Customer> getCustomers(){
        log.info("getCustomers() was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
        log.info("getCustomer() called");
        return customerRepository
                .findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException(String.format("Customer with id %d not found.", id));
                    log.error(String.format("Error in getting customer %d", id), notFoundException);
                    return notFoundException;
                });
    }

}
