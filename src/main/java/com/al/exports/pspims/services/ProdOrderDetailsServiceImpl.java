package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.ProdOrderDetails;

import java.util.Set;
import java.util.UUID;

public class ProdOrderDetailsServiceImpl implements ProdOrderDetailsService {
    @Override
    public Set<ProdOrderDetails> findAll() {
        return Set.of();
    }

    @Override
    public ProdOrderDetails findById(UUID uuid) {
        return null;
    }

    @Override
    public ProdOrderDetails save(ProdOrderDetails object) {
        return null;
    }

    @Override
    public void delete(ProdOrderDetails object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
