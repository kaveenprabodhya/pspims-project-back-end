package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.VehicleAvailabilityStatusEnum;
import com.al.exports.pspims.shared.enums.VehicleTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DeliveryVehicle extends BaseEntity {
    private String vehicleRegNo;
    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum vehicleType;
    @Enumerated(EnumType.STRING)
    private VehicleAvailabilityStatusEnum availabilityStatus;
}
