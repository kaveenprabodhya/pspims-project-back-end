package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.VehicleAvailabilityStatusEnum;
import com.al.exports.pspims.shared.enums.VehicleTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class DeliveryVehicleDTO extends BaseItem {

    @NotNull(message = "Vehicle registration number cannot be blank.")
    private BigInteger vehicleRegNo;
    @NotNull(message = "Vehicle type cannot be null.")
    private VehicleTypeEnum vehicleType;
    @NotNull(message = "Availability status is required.")
    private VehicleAvailabilityStatusEnum availabilityStatus;
}
