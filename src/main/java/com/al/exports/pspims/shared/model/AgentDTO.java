package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.AgentDepartmentTypeEnum;
import com.al.exports.pspims.shared.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AgentDTO extends PersonDTO {

    @NotBlank(message = "Username is required and cannot be blank.")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters.")
    private String username;
    @NotBlank(message = "Password is required and cannot be blank.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;
    private Role role;
    @NotNull(message = "Agent department cannot be null.")
    private AgentDepartmentTypeEnum agentDepartment;
    @PositiveOrZero(message = "Performance rate must be zero or a positive number.")
    private Float performanceRate;
}
