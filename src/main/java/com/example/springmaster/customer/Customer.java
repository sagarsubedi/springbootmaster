// This is the Model for the Customer entity

package com.example.springmaster.customer;

public class Customer {
    private final Long id;
    private final String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
