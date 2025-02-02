package com.al.exports.pspims.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SupplierPaymentDetails extends BaseEntity {

    @Builder
    public SupplierPaymentDetails(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                                  PaymentDetails paymentDetails, Supplier supplier) {
        super(id, version, createdDate, lastModifiedDate);
        this.paymentDetails = paymentDetails;
        this.supplier = supplier;
    }

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