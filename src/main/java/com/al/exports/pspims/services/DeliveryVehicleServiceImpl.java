package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.DeliveryVehicleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class DeliveryVehicleServiceImpl implements DeliveryVehicleService {

    @Override
    public Page<DeliveryVehicleDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public DeliveryVehicleDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public DeliveryVehicleDTO create(DeliveryVehicleDTO object) {
        return null;
    }

    @Override
    public DeliveryVehicleDTO update(UUID id, DeliveryVehicleDTO object) {
        return null;
    }

    @Override
    public DeliveryVehicleDTO patch(UUID id, DeliveryVehicleDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
