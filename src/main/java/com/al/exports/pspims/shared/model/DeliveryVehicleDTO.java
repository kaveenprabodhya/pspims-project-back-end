package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.VehicleAvailabilityStatusEnum;
import com.al.exports.pspims.shared.enums.VehicleTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class DeliveryVehicleDTO extends BaseItem {

    private String vehicleRegNo;
    private VehicleTypeEnum vehicleType;
    private VehicleAvailabilityStatusEnum availabilityStatus;
}
