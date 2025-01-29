package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.VinegarProdOrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class VinegarProdOrderServiceImpl implements VinegarProdOrderService {

    @Override
    public Page<VinegarProdOrderDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public VinegarProdOrderDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public VinegarProdOrderDTO create(VinegarProdOrderDTO object) {
        return null;
    }

    @Override
    public VinegarProdOrderDTO update(UUID id, VinegarProdOrderDTO object) {
        return null;
    }

    @Override
    public VinegarProdOrderDTO patch(UUID id, VinegarProdOrderDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
