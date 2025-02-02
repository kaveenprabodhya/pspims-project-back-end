package com.al.exports.pspims.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CopraSale extends BaseEntity {

    @Builder
    public CopraSale(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, Integer saleQuantity,
                     Float pricePerQuantity, Float totalSaleAmount, Date saleDate, Customer customer,
                     ShippingPlan shippingPlan, PaymentDetails paymentDetails) {
        super(id, version, createdDate, lastModifiedDate);
        this.saleQuantity = saleQuantity;
        this.pricePerQuantity = pricePerQuantity;
        this.totalSaleAmount = totalSaleAmount;
        this.saleDate = saleDate;
        this.customer = customer;
        this.shippingPlan = shippingPlan;
        this.paymentDetails = paymentDetails;
    }

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
