package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.CustomerType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDTO extends PersonDTO {

    private CustomerType customerType;
    private Float creditLimit;
    private AgentDTO agent;
    private Set<OrderDTO> order;
    private Set<CopraSaleDTO> copraSale;
}
