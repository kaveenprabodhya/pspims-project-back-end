package com.al.exports.pspims.services;


import com.al.exports.pspims.shared.model.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CustomerDTO findById(UUID uuid) {
        return null;
    }

    @Override
    public CustomerDTO create(CustomerDTO object) {
        return null;
    }

    @Override
    public CustomerDTO update(UUID id, CustomerDTO object) {
        return null;
    }

    @Override
    public CustomerDTO patch(UUID id, CustomerDTO object) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
