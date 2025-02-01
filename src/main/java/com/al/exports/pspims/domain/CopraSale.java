package com.al.exports.pspims.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CopraSale extends BaseEntity {

    private Integer saleQuantity;
    private Float pricePerQuantity;
    private Float totalSaleAmount;
    private Date saleDate;

    // many copra hv one customer
    @ManyToOne
    private Customer customer;
    //one copraSale hv one sP
    @OneToOne
    private ShippingPlan shippingPlan;
    // one copraSale hv one pD
    @OneToOne
    private PaymentDetails paymentDetails;

    @PrePersist
    @PreUpdate
    private void calculateTotalSaleAmount() {
        if (saleQuantity != null && pricePerQuantity != null) {
            this.totalSaleAmount = saleQuantity * pricePerQuantity;
        }
    }
}
