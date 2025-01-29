package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.BeverageTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class BeverageTypeServiceImpl implements BeverageTypeService {

    @Override
    public Page<BeverageTypeDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public BeverageTypeDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public BeverageTypeDTO create(BeverageTypeDTO object) {
        return null;
    }

    @Override
    public BeverageTypeDTO update(UUID id, BeverageTypeDTO object) {
        return null;
    }

    @Override
    public BeverageTypeDTO patch(UUID id, BeverageTypeDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
