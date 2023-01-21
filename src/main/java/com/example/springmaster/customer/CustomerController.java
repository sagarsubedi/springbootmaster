// this is the controller layer

package com.example.springmaster.customer;

import com.example.springmaster.SpringmasterApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/api/customer")
    public Customer getCustomer(){
        return new Customer(1L, "Sagar");
    }

}
