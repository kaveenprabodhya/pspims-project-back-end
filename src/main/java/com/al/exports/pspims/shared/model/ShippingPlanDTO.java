package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.DeliveryTypeEnum;
import com.al.exports.pspims.shared.enums.ShippingStatusEnum;
import com.al.exports.pspims.shared.enums.ShippingTypeEnum;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ShippingPlanDTO extends BaseItem {

    @NotBlank(message = "Shipping address cannot be blank.")
    private String shippingAddress;
    @FutureOrPresent(message = "Shipping date cannot be in the past.")
    private Date shippingDate;
    @NotNull(message = "Tracking number is required.")
    private UUID trackingNumber;
    @NotNull(message = "Shipping type is required.")
    private ShippingTypeEnum shippingType;
    @NotNull(message = "Shipping status is required.")
    private ShippingStatusEnum shippingStatus;
    @NotNull(message = "Delivery type is required.")
    private DeliveryTypeEnum deliveryType;
    private DeliveryVehicleDTO deliveryVehicle;
}
