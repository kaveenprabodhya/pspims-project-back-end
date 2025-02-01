package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.VehicleAvailabilityStatusEnum;
import com.al.exports.pspims.shared.enums.VehicleTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class DeliveryVehicleDTO extends BaseItem {

    @NotBlank
    private BigInteger vehicleRegNo;
    @NotBlank
    private VehicleTypeEnum vehicleType;
    @NotNull
    private VehicleAvailabilityStatusEnum availabilityStatus;
}
