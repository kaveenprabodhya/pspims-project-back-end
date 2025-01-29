package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.CoconutPurchaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class CoconutPurchaseServiceImpl implements CoconutPurchaseService {

    @Override
    public Page<CoconutPurchaseDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CoconutPurchaseDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public CoconutPurchaseDTO create(CoconutPurchaseDTO object) {
        return null;
    }

    @Override
    public CoconutPurchaseDTO update(UUID id, CoconutPurchaseDTO object) {
        return null;
    }

    @Override
    public CoconutPurchaseDTO patch(UUID id, CoconutPurchaseDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
