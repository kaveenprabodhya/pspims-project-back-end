package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.SupplierPaymentDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class SupplierPaymentDetailsServiceImpl implements SupplierPaymentDetailsService {

    @Override
    public Page<SupplierPaymentDetailsDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public SupplierPaymentDetailsDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public SupplierPaymentDetailsDTO create(SupplierPaymentDetailsDTO object) {
        return null;
    }

    @Override
    public SupplierPaymentDetailsDTO update(UUID id, SupplierPaymentDetailsDTO object) {
        return null;
    }

    @Override
    public SupplierPaymentDetailsDTO patch(UUID id, SupplierPaymentDetailsDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
