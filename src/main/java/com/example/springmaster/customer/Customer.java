// This is the Model for the Customer entity

package com.example.springmaster.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
