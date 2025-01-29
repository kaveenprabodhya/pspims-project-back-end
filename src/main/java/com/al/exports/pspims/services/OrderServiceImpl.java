package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public OrderDTO create(OrderDTO object) {
        return null;
    }

    @Override
    public OrderDTO update(UUID id, OrderDTO object) {
        return null;
    }

    @Override
    public OrderDTO patch(UUID id, OrderDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
