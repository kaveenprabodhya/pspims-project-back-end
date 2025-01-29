package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.InventoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class InventoryServiceImpl implements InventoryService {

    @Override
    public Page<InventoryDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public InventoryDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public InventoryDTO create(InventoryDTO object) {
        return null;
    }

    @Override
    public InventoryDTO update(UUID id, InventoryDTO object) {
        return null;
    }

    @Override
    public InventoryDTO patch(UUID id, InventoryDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
