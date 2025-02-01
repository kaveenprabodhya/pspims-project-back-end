package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CopraSaleDTO extends BaseItem {

    @Positive
    private Integer saleQuantity;
    @Positive
    private Float pricePerQuantity;
    @Positive
    private Float totalSaleAmount;
    @PastOrPresent
    private Date saleDate;
    private CustomerDTO customer;
    private ShippingPlanDTO shippingPlan;
    private PaymentDetailsDTO paymentDetails;
}
