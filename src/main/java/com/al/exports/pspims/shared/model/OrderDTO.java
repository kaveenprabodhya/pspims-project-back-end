package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.OrderStatusEnum;
import jakarta.validation.constraints.NotNull;
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
public class OrderDTO extends BaseItem {

//    @PastOrPresent(message = "Order date cannot be in the future.")
    private Date orderDate;
    @NotNull(message = "Order status is required.")
    private OrderStatusEnum orderStatus;
    private CoconutWaterProdOrderDTO coconutWaterProdOrder;
    private VinegarProdOrderDTO vinegarProdOrder;
    private BeverageProdOrderDTO beverageProdOrder;
    @NotNull(message = "Payment details are required.")
    private PaymentDetailsDTO paymentDetails;
    @NotNull(message = "Customer is required.")
    private CustomerDTO customer;
    @NotNull(message = "Shipping plan is required.")
    private ShippingPlanDTO shippingPlan;
}
