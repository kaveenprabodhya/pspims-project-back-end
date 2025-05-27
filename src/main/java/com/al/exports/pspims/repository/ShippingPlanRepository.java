package com.al.exports.pspims.repository;

import com.al.exports.pspims.domain.ShippingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShippingPlanRepository extends JpaRepository<ShippingPlan, UUID> {
    boolean existsByDeliveryVehicleId(UUID deliveryVehicleId);
}
