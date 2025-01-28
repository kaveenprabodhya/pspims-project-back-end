package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.Order;

import java.util.Set;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    @Override
    public Set<Order> findAll() {
        return Set.of();
    }

    @Override
    public Order findById(UUID uuid) {
        return null;
    }

    @Override
    public Order save(Order object) {
        return null;
    }

    @Override
    public void delete(Order object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
