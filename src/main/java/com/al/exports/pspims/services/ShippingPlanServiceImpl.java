package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.ShippingPlan;

import java.util.Set;
import java.util.UUID;

public class ShippingPlanServiceImpl implements ShippingPlanService {
    @Override
    public Set<ShippingPlan> findAll() {
        return Set.of();
    }

    @Override
    public ShippingPlan findById(UUID uuid) {
        return null;
    }

    @Override
    public ShippingPlan save(ShippingPlan object) {
        return null;
    }

    @Override
    public void delete(ShippingPlan object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
