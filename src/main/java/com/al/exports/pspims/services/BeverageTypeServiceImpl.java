package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.BeverageType;

import java.util.Set;
import java.util.UUID;

public class BeverageTypeServiceImpl implements BeverageTypeService {
    @Override
    public Set<BeverageType> findAll() {
        return Set.of();
    }

    @Override
    public BeverageType findById(UUID uuid) {
        return null;
    }

    @Override
    public BeverageType save(BeverageType object) {
        return null;
    }

    @Override
    public void delete(BeverageType object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
