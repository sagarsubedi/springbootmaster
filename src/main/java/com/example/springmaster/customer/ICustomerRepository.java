// This is the DAO Layer. Client -> Controller -> Service -> DAO
package com.example.springmaster.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository // more precise
//@Component
// when we annotate with component, spring creates new instance of the class. default scope is singleton
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}

//public interface ICustomerRepository {
//
//    public List<Customer> getCustomers();
//}
