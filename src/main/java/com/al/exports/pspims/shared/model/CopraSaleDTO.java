package com.al.exports.pspims.shared.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CopraSaleDTO extends BaseItem {

    private Float saleQuantity;
    private Float pricePerQuantity;
    private Float totalSaleAmount;
    private Date saleDate;
    private CustomerDTO customer;
    private ShippingPlanDTO shippingPlan;
    private PaymentDetailsDTO paymentDetails;
}
