package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.Supplier;

import java.util.Set;
import java.util.UUID;

public class SupplierServiceImpl implements SupplierService {
    @Override
    public Set<Supplier> findAll() {
        return Set.of();
    }

    @Override
    public Supplier findById(UUID uuid) {
        return null;
    }

    @Override
    public Supplier save(Supplier object) {
        return null;
    }

    @Override
    public void delete(Supplier object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
