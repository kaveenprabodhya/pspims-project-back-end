package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ShippingPlan extends BaseEntity {

    private String shippingAddress;
    private Date shippingDate;
    private UUID trackingNumber;
    private ShippingTypeEnum shippingType; //on store or home delivery
    private ShippingStatusEnum shippingStatus;
    private DeliveryTypeEnum deliveryTypeEnum;
    // one sP hv one dV
    @OneToOne
    private DeliveryVehicle deliveryVehicle;
}
