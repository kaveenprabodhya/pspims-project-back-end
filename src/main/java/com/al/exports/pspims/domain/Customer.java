package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.CustomerType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends Person {

    @Builder
    public Customer(String firstName, String lastName, String email, String address, CustomerType customerType, Float creditLimit, Agent agent, Set<Order> order, Set<CopraSale> copraSale) {
        super(firstName, lastName, email, address);
        this.customerType = customerType;
        this.creditLimit = creditLimit;
        this.agent = agent;
        this.order = order;
        this.copraSale = copraSale;
    }

    private CustomerType customerType;
    private Float creditLimit;

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
