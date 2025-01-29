package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.ShippingPlanDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class ShippingPlanServiceImpl implements ShippingPlanService {

    @Override
    public Page<ShippingPlanDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ShippingPlanDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public ShippingPlanDTO create(ShippingPlanDTO object) {
        return null;
    }

    @Override
    public ShippingPlanDTO update(UUID id, ShippingPlanDTO object) {
        return null;
    }

    @Override
    public ShippingPlanDTO patch(UUID id, ShippingPlanDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
