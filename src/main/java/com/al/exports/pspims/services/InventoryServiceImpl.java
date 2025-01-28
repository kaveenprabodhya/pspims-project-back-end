package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.Inventory;

import java.util.Set;
import java.util.UUID;

public class InventoryServiceImpl implements InventoryService {
    @Override
    public Set<Inventory> findAll() {
        return Set.of();
    }

    @Override
    public Inventory findById(UUID uuid) {
        return null;
    }

    @Override
    public Inventory save(Inventory object) {
        return null;
    }

    @Override
    public void delete(Inventory object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
