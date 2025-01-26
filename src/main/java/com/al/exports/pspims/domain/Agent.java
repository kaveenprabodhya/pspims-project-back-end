package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Agent  extends BaseEntity {

    @Builder
    public Agent(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, Person person,
                 AgentDepartmentTypeEnum agentDepartment, float performanceRate, UUID apiKey) {
        super(id, version, createdDate, lastModifiedDate);
        this.person = person;
        this.agentDepartment = agentDepartment;
        this.performanceRate = performanceRate;
        this.apiKey = apiKey;
    }

    private Person person;
    private AgentDepartmentTypeEnum agentDepartment;
    private float performanceRate;
    private UUID apiKey;
}
