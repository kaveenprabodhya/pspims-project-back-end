package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SupplierPaymentDetails extends BaseEntity {

    // one sp hv one sPD
    @OneToOne
    private PaymentDetails paymentDetails;
    // many payments for one supplier
    @ManyToOne
    private Supplier supplier;
}