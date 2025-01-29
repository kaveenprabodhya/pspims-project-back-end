package com.al.exports.pspims.services;

import com.al.exports.pspims.shared.model.PaymentDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    @Override
    public Page<PaymentDetailsDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public PaymentDetailsDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public PaymentDetailsDTO create(PaymentDetailsDTO object) {
        return null;
    }

    @Override
    public PaymentDetailsDTO update(UUID id, PaymentDetailsDTO object) {
        return null;
    }

    @Override
    public PaymentDetailsDTO patch(UUID id, PaymentDetailsDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
