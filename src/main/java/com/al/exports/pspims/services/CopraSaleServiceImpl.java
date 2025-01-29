package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.CopraSaleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class CopraSaleServiceImpl implements CopraSaleService {

    @Override
    public Page<CopraSaleDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CopraSaleDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public CopraSaleDTO create(CopraSaleDTO object) {
        return null;
    }

    @Override
    public CopraSaleDTO update(UUID id, CopraSaleDTO object) {
        return null;
    }

    @Override
    public CopraSaleDTO patch(UUID id, CopraSaleDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
