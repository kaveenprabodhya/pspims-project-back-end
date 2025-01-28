package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.DeliveryVehicle;

import java.util.Set;
import java.util.UUID;

public class DeliveryVehicleServiceImpl implements DeliveryVehicleService {
    @Override
    public Set<DeliveryVehicle> findAll() {
        return Set.of();
    }

    @Override
    public DeliveryVehicle findById(UUID uuid) {
        return null;
    }

    @Override
    public DeliveryVehicle save(DeliveryVehicle object) {
        return null;
    }

    @Override
    public void delete(DeliveryVehicle object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
