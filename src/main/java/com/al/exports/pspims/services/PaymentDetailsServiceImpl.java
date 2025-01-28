package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.PaymentDetails;

import java.util.Set;
import java.util.UUID;

public class PaymentDetailsServiceImpl implements PaymentDetailsService {
    @Override
    public Set<PaymentDetails> findAll() {
        return Set.of();
    }

    @Override
    public PaymentDetails findById(UUID uuid) {
        return null;
    }

    @Override
    public PaymentDetails save(PaymentDetails object) {
        return null;
    }

    @Override
    public void delete(PaymentDetails object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
