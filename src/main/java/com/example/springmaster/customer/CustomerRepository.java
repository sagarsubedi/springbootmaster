// This is the DAO Layer. Client -> Controller -> Service -> DAO
package com.example.springmaster.customer;

import java.util.List;

// @Repository // more precise
//@Component
// when we annotate with component, spring creates new instance of the class. default scope is singleton
public class CustomerRepository implements ICustomerRepo{

    @Override
    public List<Customer> getCustomers(){
        // TODO connect to real DB
        return List.of (
                new Customer(1L, "TODO. Implement real DB", "realrepopassword", "email@gmail.com"),
                new Customer(2L, "TODO. code front end", "realrepopassword", "email@gmail.com"),
                new Customer(3L, "TODO. host in db", "realrepopassword", "email@gmail.com"),
                new Customer(4L, "TODO. setup ci/cd", "realrepopassword", "email@gmail.com")
        );
    }
}
