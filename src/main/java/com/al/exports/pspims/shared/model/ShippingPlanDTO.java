package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.DeliveryTypeEnum;
import com.al.exports.pspims.shared.enums.ShippingStatusEnum;
import com.al.exports.pspims.shared.enums.ShippingTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ShippingPlanDTO extends BaseItem {

    private String shippingAddress;
    private Date shippingDate;
    private UUID trackingNumber;
    private ShippingTypeEnum shippingType;
    private ShippingStatusEnum shippingStatus;
    private DeliveryTypeEnum deliveryTypeEnum;
    private DeliveryVehicleDTO deliveryVehicle;
}
