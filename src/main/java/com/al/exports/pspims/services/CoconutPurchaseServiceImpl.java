package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.CoconutPurchase;

import java.util.Set;
import java.util.UUID;

public class CoconutPurchaseServiceImpl implements CoconutPurchaseService {
    @Override
    public Set<CoconutPurchase> findAll() {
        return Set.of();
    }

    @Override
    public CoconutPurchase findById(UUID uuid) {
        return null;
    }

    @Override
    public CoconutPurchase save(CoconutPurchase object) {
        return null;
    }

    @Override
    public void delete(CoconutPurchase object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
