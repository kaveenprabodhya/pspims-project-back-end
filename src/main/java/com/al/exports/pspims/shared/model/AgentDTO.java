package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.domain.Supplier;
import com.al.exports.pspims.shared.enums.AgentDepartmentTypeEnum;
import com.al.exports.pspims.shared.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class AgentDTO extends PersonDTO {
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;
    @NotBlank
    @Size(min = 6)
    private String password;
    @NotNull
    private Role role;
    @NotNull
    private AgentDepartmentTypeEnum agentDepartment;
    @PositiveOrZero
    private Float performanceRate;
    private String apiKey;
    private Set<CustomerDTO> customers;
    private Set<Supplier> suppliers;
}
