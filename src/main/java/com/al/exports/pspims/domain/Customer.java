package com.al.exports.pspims.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer extends Person {

    private CustomerType customerType;
    private float creditLimit;

    // one agent many customer
    @ManyToOne
    private Agent agent;

    // one customer to Many order
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order> order;

    // one customer to Many copraSale
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<CopraSale> copraSale;
}
