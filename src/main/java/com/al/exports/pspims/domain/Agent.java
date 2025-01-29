package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.AgentDepartmentTypeEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
public class Agent  extends Person {

    @Builder
    public Agent(String firstName, String lastName, String email, String address, AgentDepartmentTypeEnum agentDepartment, float performanceRate, UUID apiKey, Set<Customer> customer) {
        super(firstName, lastName, email, address);
        this.agentDepartment = agentDepartment;
        this.performanceRate = performanceRate;
        this.apiKey = apiKey;
        this.customer = customer;
    }

    private AgentDepartmentTypeEnum agentDepartment;
    private Float performanceRate;
    private UUID apiKey;

    // one agent many customers
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Set<Customer> customer;
}
