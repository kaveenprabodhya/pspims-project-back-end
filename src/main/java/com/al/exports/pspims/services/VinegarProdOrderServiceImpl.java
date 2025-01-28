package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.VinegarProdOrder;

import java.util.Set;
import java.util.UUID;

public class VinegarProdOrderServiceImpl implements VinegarProdOrderService {
    @Override
    public Set<VinegarProdOrder> findAll() {
        return Set.of();
    }

    @Override
    public VinegarProdOrder findById(UUID uuid) {
        return null;
    }

    @Override
    public VinegarProdOrder save(VinegarProdOrder object) {
        return null;
    }

    @Override
    public void delete(VinegarProdOrder object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
