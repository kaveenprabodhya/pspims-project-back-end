package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.ProdOrderDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class ProdOrderDetailsServiceImpl implements ProdOrderDetailsService {

    @Override
    public Page<ProdOrderDetailsDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProdOrderDetailsDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public ProdOrderDetailsDTO create(ProdOrderDetailsDTO object) {
        return null;
    }

    @Override
    public ProdOrderDetailsDTO update(UUID id, ProdOrderDetailsDTO object) {
        return null;
    }

    @Override
    public ProdOrderDetailsDTO patch(UUID id, ProdOrderDetailsDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
