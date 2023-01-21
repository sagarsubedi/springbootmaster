// this is the controller layer

package com.example.springmaster.customer;

import com.example.springmaster.SpringmasterApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/customer")
    void createCustomer(@RequestBody Customer customer){
        System.out.println("Customer created");
    }

    @DeleteMapping(path="{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Customer with id "  + id  +" deleted");
    }

    @PutMapping("/api/customer")
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("Update request for customer ");
    }

}
