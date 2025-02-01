package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.OrderStatusEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends BaseItem {

    @PastOrPresent
    private Date orderDate;
    @NotNull
    private OrderStatusEnum orderStatus;
    private CoconutWaterProdOrderDTO coconutWaterProdOrder;
    private VinegarProdOrderDTO vinegarProdOrder;
    private BeverageProdOrderDTO beverageProdOrder;
    @NotNull
    private PaymentDetailsDTO paymentDetails;
    @NotNull
    private CustomerDTO customer;
    @NotNull
    private ShippingPlanDTO shippingPlan;
}
