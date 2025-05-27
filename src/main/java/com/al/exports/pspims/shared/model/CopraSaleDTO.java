package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CopraSaleDTO extends BaseItem {

    @Positive(message = "Sale quantity must be a positive number.")
    private Integer saleQuantity;
    @Positive(message = "Price per quantity must be a positive number.")
    private Float pricePerQuantity;
    @Positive(message = "Total sale amount must be a positive number.")
    private Float totalSaleAmount;
//    @PastOrPresent(message = "Sale date cannot be in the future.")
    private Date saleDate;
    private CustomerDTO customer;
    private ShippingPlanDTO shippingPlan;
    private PaymentDetailsDTO paymentDetails;
}
