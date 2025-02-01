package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.DeliveryTypeEnum;
import com.al.exports.pspims.shared.enums.ShippingStatusEnum;
import com.al.exports.pspims.shared.enums.ShippingTypeEnum;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ShippingPlanDTO extends BaseItem {

    @NotBlank
    private String shippingAddress;
    @FutureOrPresent
    private Date shippingDate;
    @NotNull
    private UUID trackingNumber;
    @NotNull
    private ShippingTypeEnum shippingType;
    @NotNull
    private ShippingStatusEnum shippingStatus;
    @NotNull
    private DeliveryTypeEnum deliveryType;
    private DeliveryVehicleDTO deliveryVehicle;
}
