package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.SupplierPaymentTermsEnum;
import com.al.exports.pspims.shared.enums.SupplierStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class SupplierDTO extends PersonDTO {

    @NotNull(message = "Supplier status is required.")
    private SupplierStatusEnum supplierStatus;
    @NotNull(message = "Supplier payment terms are required.")
    private SupplierPaymentTermsEnum supplierPaymentTerms;
    private AgentDTO agent;
}
