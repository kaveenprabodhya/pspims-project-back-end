package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "all_orders")
public class Order extends BaseEntity {

    private Date orderDate;
    private Float totalOrderAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    // one order hv one cWPO
    @OneToOne
    private CoconutWaterProdOrder coconutWaterProdOrder;
    // one order hv one vPO
    @OneToOne
    private VinegarProdOrder vinegarProdOrder;
    // one order hv one bevPO
    @OneToOne
    private BeverageProdOrder beverageProdOrder;
    // one order one pD
    @OneToOne
    private PaymentDetails paymentDetails;
    // many orders hv one customer
    @ManyToOne
    private Customer customer;
    // one order hv one sP
    @OneToOne
    private ShippingPlan shippingPlan;
}
