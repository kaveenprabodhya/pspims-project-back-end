package com.al.exports.pspims.services;

import com.al.exports.pspims.domain.Customer;

import java.util.Set;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public Set<Customer> findAll() {
        return Set.of();
    }

    @Override
    public Customer findById(UUID uuid) {
        return null;
    }

    @Override
    public Customer save(Customer object) {
        return null;
    }

    @Override
    public void delete(Customer object) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
