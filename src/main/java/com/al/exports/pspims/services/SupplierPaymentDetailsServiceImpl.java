package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.SupplierPaymentDetails;
import com.al.exports.pspims.repository.SupplierPaymentDetailsRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.PaymentDetailsMapper;
import com.al.exports.pspims.shared.mapper.SupplierMapper;
import com.al.exports.pspims.shared.mapper.SupplierPaymentDetailsMapper;
import com.al.exports.pspims.shared.model.SupplierPaymentDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplierPaymentDetailsServiceImpl implements SupplierPaymentDetailsService {

    private final SupplierPaymentDetailsRepository supplierPaymentDetailsRepository;
    private final SupplierPaymentDetailsMapper supplierPaymentDetailsMapper;
    private final SupplierMapper supplierMapper;
    private final PaymentDetailsMapper paymentDetailsMapper;

    @Override
    public Page<SupplierPaymentDetailsDTO> findAll(Pageable pageable) {
        Page<SupplierPaymentDetails> supplierPaymentDetails = supplierPaymentDetailsRepository.findAll(pageable);
        return supplierPaymentDetails.map(supplierPaymentDetailsMapper::supplierPaymentDetailsToSupplierPaymentDetailsDTO);
    }

    @Override
    public SupplierPaymentDetailsDTO findById(UUID uuid) {
        return supplierPaymentDetailsRepository
                .findById(uuid)
                .map(supplierPaymentDetailsMapper::supplierPaymentDetailsToSupplierPaymentDetailsDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found supplier payment detail with id: " + uuid));
    }

    @Override
    public SupplierPaymentDetailsDTO create(SupplierPaymentDetailsDTO supplierPaymentDetailsDTO) {
        return saveAndReturnDTO(supplierPaymentDetailsMapper.supplierPaymentDetailsDtoToSupplierPaymentDetails(supplierPaymentDetailsDTO));
    }

    @Override
    public SupplierPaymentDetailsDTO update(UUID id, SupplierPaymentDetailsDTO supplierPaymentDetailsDTO) {
        SupplierPaymentDetails supplierPaymentDetails = supplierPaymentDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found supplier payment detail with id: " + id));
        supplierPaymentDetails.setPaymentDetails(paymentDetailsMapper.paymentDetailsDtoToPaymentDetails(supplierPaymentDetailsDTO.getPaymentDetails()));
        supplierPaymentDetails.setSupplier(supplierMapper.supplierDtoToSupplier(supplierPaymentDetailsDTO.getSupplier()));
        return saveAndReturnDTO(supplierPaymentDetails);
    }

    @Override
    public SupplierPaymentDetailsDTO patch(UUID id, SupplierPaymentDetailsDTO supplierPaymentDetailsDTO) {
        return supplierPaymentDetailsRepository
                .findById(id)
                .map(supplierPaymentDetails -> {
                    if(supplierPaymentDetailsDTO.getPaymentDetails() != null) {
                        supplierPaymentDetails
                                .setPaymentDetails(paymentDetailsMapper
                                        .paymentDetailsDtoToPaymentDetails(supplierPaymentDetailsDTO
                                                .getPaymentDetails()
                                        )
                                );
                    }
                    if(supplierPaymentDetailsDTO.getSupplier() != null) {
                        supplierPaymentDetails.setSupplier(supplierMapper
                                .supplierDtoToSupplier(supplierPaymentDetailsDTO.getSupplier())
                        );
                    }
                    return saveAndReturnDTO(supplierPaymentDetails);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found supplier payment detail with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        supplierPaymentDetailsRepository.deleteById(uuid);
    }

    private SupplierPaymentDetailsDTO saveAndReturnDTO(SupplierPaymentDetails supplierPaymentDetails){
        SupplierPaymentDetails returnSupplierPaymentDetails = supplierPaymentDetailsRepository.save(supplierPaymentDetails);
        return supplierPaymentDetailsMapper.supplierPaymentDetailsToSupplierPaymentDetailsDTO(returnSupplierPaymentDetails);
    }

}
