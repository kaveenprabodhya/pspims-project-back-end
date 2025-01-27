package com.al.exports.pspims.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Agent  extends Person {

    private AgentDepartmentTypeEnum agentDepartment;
    private float performanceRate;
    private UUID apiKey;

    // one agent many customers
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Set<Customer> customer;
}
