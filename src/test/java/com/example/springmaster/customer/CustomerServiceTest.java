package com.example.springmaster.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private ICustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        // given
        Customer sagar = new Customer(1L, "sagar", "password","sagar@gmail.com");
        Customer subedi = new Customer(2L, "subedi", "password","subedi@gmail.com");
        customerRepository.saveAll(Arrays.asList(sagar, subedi));

        // when
        List<Customer> customers = underTest.getCustomers();

        // then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer sagar = new Customer(1L, "sagar", "password","sagar@gmail.com");
        customerRepository.save(sagar);

        Customer customer = underTest.getCustomer(1L);

        assertEquals(1L, customer.getId());
        assertEquals("sagar", customer.getName());
        assertEquals("password", customer.getPassword());
        assertEquals("sagar@gmail.com", customer.getEmail());
    }
}