package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.Customer;
import com.al.exports.pspims.repository.CustomerRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.AgentMapper;
import com.al.exports.pspims.shared.mapper.CustomerMapper;
import com.al.exports.pspims.shared.model.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AgentMapper agentMapper;

    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.map(customerMapper::customerToCustomerDTO);
    }

    @Override
    public CustomerDTO findById(UUID uuid) {
        return customerRepository.findById(uuid).map(customerMapper::customerToCustomerDTO).orElseThrow(() -> new ResourceNotFoundException("Not found customer with id: " + uuid));
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        return saveAndReturnDTO(customerMapper.customerDtoToCustomer(customerDTO));
    }

    @Override
    public CustomerDTO update(UUID id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found customer with id: " + id));
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setCreditLimit(customerDTO.getCreditLimit());
        customer.setCustomerType(customerDTO.getCustomerType());
        customer.setAgent(agentMapper.agentDtoToAgent(customerDTO.getAgent()));
        return saveAndReturnDTO(customer);
    }

    @Override
    public CustomerDTO patch(UUID id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if(customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }
            if(customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }
            if(customerDTO.getEmail() != null){
                customer.setEmail(customerDTO.getEmail());
            }
            if(customerDTO.getAddress() != null){
                customer.setAddress(customerDTO.getAddress());
            }
            if(customerDTO.getCreditLimit() != null){
                customer.setCreditLimit(customerDTO.getCreditLimit());
            }
            if(customerDTO.getCustomerType() != null){
                customer.setCustomerType(customerDTO.getCustomerType());
            }
            if(customerDTO.getAgent() != null){
                customer.setAgent(agentMapper.agentDtoToAgent(customerDTO.getAgent()));
            }
            return saveAndReturnDTO(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found customer with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        customerRepository.deleteById(uuid);
    }

    private CustomerDTO saveAndReturnDTO(Customer customer){
        Customer returnCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(returnCustomer);
    }
}
