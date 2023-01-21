// This is the DAO Layer. Client -> Controller -> Service -> DAO
package com.example.springmaster.customer;

import java.util.Collections;
import java.util.List;


public class CustomerFakeRepository implements ICustomerRepo{

    @Override
    public List<Customer> getCustomers(){
        return Collections.singletonList(
                new Customer(1L, "this is from fake repo", "testpassword")
        );
    }
}
