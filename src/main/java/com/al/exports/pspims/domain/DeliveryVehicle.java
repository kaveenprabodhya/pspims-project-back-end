package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.VehicleAvailabilityStatusEnum;
import com.al.exports.pspims.shared.enums.VehicleTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class DeliveryVehicle extends BaseEntity {

    @Builder
    public DeliveryVehicle(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                           BigInteger vehicleRegNo, VehicleTypeEnum vehicleType,
                           VehicleAvailabilityStatusEnum availabilityStatus) {
        super(id, version, createdDate, lastModifiedDate);
        this.vehicleRegNo = vehicleRegNo;
        this.vehicleType = vehicleType;
        this.availabilityStatus = availabilityStatus;
    }

    private BigInteger vehicleRegNo;
    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum vehicleType;
    @Enumerated(EnumType.STRING)
    private VehicleAvailabilityStatusEnum availabilityStatus;
}
