package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.DeliveryTypeEnum;
import com.al.exports.pspims.shared.enums.ShippingStatusEnum;
import com.al.exports.pspims.shared.enums.ShippingTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private ShippingTypeEnum shippingType; //on store or home delivery
    @Enumerated(EnumType.STRING)
    private ShippingStatusEnum shippingStatus;
    @Enumerated(EnumType.STRING)
    private DeliveryTypeEnum deliveryType;
    // one sP hv one dV
    @OneToOne
    private DeliveryVehicle deliveryVehicle;
}
