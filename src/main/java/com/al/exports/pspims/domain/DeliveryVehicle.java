package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DeliveryVehicle extends BaseEntity {
    private String vehicleRegNo;
    private VehicleTypeEnum vehicleType;
    private VehicleAvailabilityStatusEnum availabilityStatus;
}
