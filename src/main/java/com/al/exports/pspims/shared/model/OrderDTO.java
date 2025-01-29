package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.OrderStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends BaseItem {

    private Date orderDate;
    private Float totalOrderAmount;
    private OrderStatusEnum orderStatus;
    private CoconutWaterProdOrderDTO coconutWaterProdOrder;
    private VinegarProdOrderDTO vinegarProdOrder;
    private BeverageProdOrderDTO beverageProdOrder;
    private PaymentDetailsDTO paymentDetails;
    private CustomerDTO customer;
    private ShippingPlanDTO shippingPlan;
}
