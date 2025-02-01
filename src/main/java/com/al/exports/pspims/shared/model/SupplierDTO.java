package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.SupplierPaymentTermsEnum;
import com.al.exports.pspims.shared.enums.SupplierStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class SupplierDTO extends PersonDTO {

    @NotNull
    private SupplierStatusEnum supplierStatus;
    @NotNull
    private SupplierPaymentTermsEnum supplierPaymentTerms;
    private AgentDTO agent;
    private Set<SupplierPaymentDetailsDTO> supplierPaymentDetails;
    private Set<CoconutPurchaseDTO> coconutPurchase;
}
