package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.BeverageProdOrder;

import java.util.Set;
import java.util.UUID;

public class BeverageProdOrderServiceImpl implements BeverageProdOrderService {
    @Override
    public Set<BeverageProdOrder> findAll() {
        return Set.of();
    }

    @Override
    public BeverageProdOrder findById(UUID uuid) {
        return null;
    }

    @Override
    public BeverageProdOrder save(BeverageProdOrder object) {
        return null;
    }

    @Override
    public void delete(BeverageProdOrder object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
