package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.CoconutWaterProdOrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class CoconutWaterProdOrderServiceImpl implements CoconutWaterProdOrderService {

    @Override
    public Page<CoconutWaterProdOrderDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CoconutWaterProdOrderDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public CoconutWaterProdOrderDTO create(CoconutWaterProdOrderDTO object) {
        return null;
    }

    @Override
    public CoconutWaterProdOrderDTO update(UUID id, CoconutWaterProdOrderDTO object) {
        return null;
    }

    @Override
    public CoconutWaterProdOrderDTO patch(UUID id, CoconutWaterProdOrderDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
