package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CopraSale extends BaseEntity {

    private float saleQuantity;
    private float pricePerQuantity;
    private float totalSaleAmount;
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
}
