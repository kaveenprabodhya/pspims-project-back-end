package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.AgentDepartmentTypeEnum;
import com.al.exports.pspims.shared.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Agent  extends Person implements UserDetails {

    @Builder
    public Agent(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String firstName,
                 String lastName, String email, String address, String username, String password, Role role,
                 AgentDepartmentTypeEnum agentDepartment, Float performanceRate, String apiKey,
                 Set<Customer> customers, Set<Supplier> suppliers) {
        super(id, version, createdDate, lastModifiedDate, firstName, lastName, email, address);
        this.username = username;
        this.password = password;
        this.role = role;
        this.agentDepartment = agentDepartment;
        this.performanceRate = performanceRate;
        this.apiKey = apiKey;
        this.customers = customers;
        this.suppliers = suppliers;
    }

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    private AgentDepartmentTypeEnum agentDepartment;

    private Float performanceRate;

    @Column(length = 512)
    private String apiKey;

    // one agent many customers
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Set<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Set<Supplier> suppliers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @PrePersist
    public void prePersist() {
        if (this.role == null) {
            this.role = Role.ROLE_AGENT;
        }
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }
}

