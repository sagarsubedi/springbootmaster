// This is the Model for the Customer entity

package com.example.springmaster.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Customer {

    @Id
    private  Long id;

    @NotBlank(message = "name cannot be empty")
    private  String name;

    @NotBlank(message = "password cannot be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;

    @Email
    @NotBlank(message = "email cannot be empty")
    // look at the javax.validation.constraints package for more constraints
    private String email;

    public Customer() {
    }

    // we need the getters so that data can be sent as json
    // getId -> get will be removed and id becomes key for the json
    // anything that starts with get will be sent to client using the name as key
    @JsonProperty("customer_id") // will allow the key to be changed to customer_id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
