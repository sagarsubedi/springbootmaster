// this is the controller layer

package com.example.springmaster.customer;

import com.example.springmaster.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path="/api/v1/customers")
// @Deprecated will deprecate the api and helps in documentation as well
public class CustomerController {

    // for dependency injection
    private final CustomerService customerService;

    @GetMapping()
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id){
        throw new ApiRequestException(
                String.format("ApiRequestException for customer %d",id)
        );
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
