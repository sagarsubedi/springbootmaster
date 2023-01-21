// this is the controller layer

package com.example.springmaster.customer;

import com.example.springmaster.SpringmasterApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    // for dependency injection
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/api/customer")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

}
