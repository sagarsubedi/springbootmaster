// this is the controller layer

package com.example.springmaster.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/customers")
// @Deprecated will deprecate the api and helps in documentation as well
public class CustomerController {

    // for dependency injection
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping()
    void createCustomer( @Valid @RequestBody Customer customer){
        System.out.println("Customer created");
    }

    @DeleteMapping(path="{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Customer with id "  + id  +" deleted");
    }

    @PutMapping()
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("Update request for customer ");
    }

}
