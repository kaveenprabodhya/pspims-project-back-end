package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.AgentDepartmentTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class AgentDTO extends PersonDTO {

    private AgentDepartmentTypeEnum agentDepartment;
    private float performanceRate;
    private UUID apiKey;
    private Set<CustomerDTO> customer;
}
