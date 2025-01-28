package com.al.exports.pspims.shared.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class SupplierPaymentDetailsDTO extends BaseItem {

    private PaymentDetailsDTO paymentDetails;
    private SupplierDTO supplier;
}