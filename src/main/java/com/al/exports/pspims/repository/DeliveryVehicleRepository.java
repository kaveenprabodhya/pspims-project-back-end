package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.DeliveryVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryVehicleRepository extends JpaRepository<DeliveryVehicle, UUID> {
}
