package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.SupplierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class SupplierServiceImpl implements SupplierService {

    @Override
    public Page<SupplierDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public SupplierDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public SupplierDTO create(SupplierDTO object) {
        return null;
    }

    @Override
    public SupplierDTO update(UUID id, SupplierDTO object) {
        return null;
    }

    @Override
    public SupplierDTO patch(UUID id, SupplierDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
