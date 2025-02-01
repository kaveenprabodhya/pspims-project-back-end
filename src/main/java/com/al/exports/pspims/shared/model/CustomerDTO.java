package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.CustomerType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDTO extends PersonDTO {

    @NotNull
    private CustomerType customerType;
    @PositiveOrZero
    private Float creditLimit;
    private AgentDTO agent;
    private Set<OrderDTO> order;
    private Set<CopraSaleDTO> copraSale;
}
