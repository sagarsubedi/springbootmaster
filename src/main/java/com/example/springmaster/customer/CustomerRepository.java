// This is the DAO Layer. Client -> Controller -> Service -> DAO
package com.example.springmaster.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// @Repository // more precise
//@Component
// when we annotate with component, spring creates new instance of the class. default scope is singleton
public class CustomerRepository implements ICustomerRepo{

    @Override
    public List<Customer> getCustomers(){
        // TODO connect to real DB
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real DB")
        );
    }
}
