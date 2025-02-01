package com.al.exports.pspims.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SupplierPaymentDetails extends BaseEntity {
//
//    @Enumerated(EnumType.STRING)
//    private SupplierProductTypeEnum supplierProductType;
//    private Float pricePerUnit;
    // one sp hv one sPD
    @OneToOne
    private PaymentDetails paymentDetails;
    // many payments for one supplier
    @ManyToOne
    private Supplier supplier;
}