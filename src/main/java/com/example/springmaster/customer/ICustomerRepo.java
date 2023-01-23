// interface to be implemented for the repo
package com.example.springmaster.customer;

import java.util.List;

@Deprecated
public interface ICustomerRepo {

    List<Customer> getCustomers();
}
