package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.CustomerType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class CustomerDTO extends PersonDTO {

    @NotNull(message = "Customer type is required.")
    private CustomerType customerType;
    @PositiveOrZero(message = "Credit limit must be zero or a positive number.")
    private Float creditLimit;
    private AgentDTO agent;
}
