package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.Supplier;
import com.al.exports.pspims.repository.SupplierRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.AgentMapper;
import com.al.exports.pspims.shared.mapper.SupplierMapper;
import com.al.exports.pspims.shared.model.SupplierDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    private final AgentMapper agentMapper;

    @Override
    public Page<SupplierDTO> findAll(Pageable pageable) {
        Page<Supplier> suppliers = supplierRepository.findAll(pageable);
        return suppliers.map(supplierMapper::supplierToSupplierDTO);
    }

    @Override
    public SupplierDTO findById(UUID uuid) {
        return supplierRepository.findById(uuid).map(supplierMapper::supplierToSupplierDTO).orElseThrow(() -> new ResourceNotFoundException("Not found supplier with id: " + uuid));
    }

    @Override
    public SupplierDTO create(SupplierDTO supplierDTO) {
        return saveAndReturnDTO(supplierMapper.supplierDtoToSupplier(supplierDTO));
    }

    @Override
    public SupplierDTO update(UUID id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found supplier with id: " + id));
        supplier.setFirstName(supplierDTO.getFirstName());
        supplier.setLastName(supplierDTO.getLastName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setSupplierStatus(supplierDTO.getSupplierStatus());
        supplier.setSupplierPaymentTerms(supplierDTO.getSupplierPaymentTerms());
        supplier.setAgent(agentMapper.agentDtoToAgent(supplierDTO.getAgent()));
        return saveAndReturnDTO(supplier);
    }

    @Override
    public SupplierDTO patch(UUID id, SupplierDTO supplierDTO) {
        return supplierRepository
                .findById(id)
                .map(supplier -> {
                    if (supplierDTO.getFirstName() != null) {
                        supplier.setFirstName(supplierDTO.getFirstName());
                    }
                    if (supplierDTO.getLastName() != null) {
                        supplier.setLastName(supplierDTO.getLastName());
                    }
                    if (supplierDTO.getEmail() != null) {
                        supplier.setEmail(supplierDTO.getEmail());
                    }
                    if (supplierDTO.getAddress() != null) {
                        supplier.setAddress(supplierDTO.getAddress());
                    }
                    if (supplierDTO.getSupplierStatus() != null) {
                        supplier.setSupplierStatus(supplierDTO.getSupplierStatus());
                    }
                    if (supplierDTO.getSupplierPaymentTerms() != null) {
                        supplier.setSupplierPaymentTerms(supplierDTO.getSupplierPaymentTerms());
                    }
                    if (supplierDTO.getAgent() != null) {
                        supplier.setAgent(agentMapper.agentDtoToAgent(supplierDTO.getAgent()));
                    }

                    return saveAndReturnDTO(supplier);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found supplier with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        supplierRepository.deleteById(uuid);
    }

    private SupplierDTO saveAndReturnDTO(Supplier supplier) {
        Supplier returnSupplier = supplierRepository.save(supplier);
        return supplierMapper.supplierToSupplierDTO(returnSupplier);
    }
}
