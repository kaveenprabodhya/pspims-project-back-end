package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.SupplierPaymentDetails;

import java.util.Set;
import java.util.UUID;

public class SupplierPaymentDetailsServiceImpl implements SupplierPaymentDetailsService
{
    @Override
    public Set<SupplierPaymentDetails> findAll() {
        return Set.of();
    }

    @Override
    public SupplierPaymentDetails findById(UUID uuid) {
        return null;
    }

    @Override
    public SupplierPaymentDetails save(SupplierPaymentDetails object) {
        return null;
    }

    @Override
    public void delete(SupplierPaymentDetails object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
