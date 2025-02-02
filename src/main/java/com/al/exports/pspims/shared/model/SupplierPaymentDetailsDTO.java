package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class SupplierPaymentDetailsDTO extends BaseItem {

    @NotNull(message = "Payment details cannot be null.")
    private PaymentDetailsDTO paymentDetails;
    @NotNull(message = "Supplier details cannot be null.")
    private SupplierDTO supplier;
}