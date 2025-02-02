package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "all_orders")
public class Order extends BaseEntity {

    @Builder
    public Order(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, Date orderDate,
                 OrderStatusEnum orderStatus, CoconutWaterProdOrder coconutWaterProdOrder,
                 VinegarProdOrder vinegarProdOrder, BeverageProdOrder beverageProdOrder, PaymentDetails paymentDetails,
                 Customer customer, ShippingPlan shippingPlan) {
        super(id, version, createdDate, lastModifiedDate);
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.coconutWaterProdOrder = coconutWaterProdOrder;
        this.vinegarProdOrder = vinegarProdOrder;
        this.beverageProdOrder = beverageProdOrder;
        this.paymentDetails = paymentDetails;
        this.customer = customer;
        this.shippingPlan = shippingPlan;
    }

    private Date orderDate;
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
