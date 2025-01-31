package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.CopraSale;
import com.al.exports.pspims.repository.CopraSaleRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.CopraSaleMapper;
import com.al.exports.pspims.shared.mapper.CustomerMapper;
import com.al.exports.pspims.shared.mapper.PaymentDetailsMapper;
import com.al.exports.pspims.shared.mapper.ShippingPlanMapper;
import com.al.exports.pspims.shared.model.CopraSaleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CopraSaleServiceImpl implements CopraSaleService {

    private final CopraSaleRepository copraSaleRepository;
    private final CopraSaleMapper copraSaleMapper;
    private final CustomerMapper customerMapper;
    private final ShippingPlanMapper shippingPlanMapper;
    private final PaymentDetailsMapper paymentDetailsMapper;

    @Override
    public Page<CopraSaleDTO> findAll(Pageable pageable) {
        Page<CopraSale> copraSales = copraSaleRepository.findAll(pageable);
        return copraSales.map(copraSaleMapper::copraSaleToCopraSaleDTO);
    }

    @Override
    public CopraSaleDTO findById(UUID uuid) {
        return copraSaleRepository.findById(uuid).map(copraSaleMapper::copraSaleToCopraSaleDTO).orElseThrow(() -> new ResourceNotFoundException("Not found copra sale with id: " + uuid));
    }

    @Override
    public CopraSaleDTO create(CopraSaleDTO copraSaleDTO) {
        return saveAndReturnDTO(copraSaleMapper.copraSaleDtoToCopraSale(copraSaleDTO));
    }

    @Override
    public CopraSaleDTO update(UUID id, CopraSaleDTO copraSaleDTO) {
        CopraSale copraSale = copraSaleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found copra sale with id: " + id));
        copraSale.setSaleQuantity(copraSaleDTO.getSaleQuantity());
        copraSale.setPricePerQuantity(copraSaleDTO.getPricePerQuantity());
        copraSale.setTotalSaleAmount(copraSaleDTO.getTotalSaleAmount());
        copraSale.setSaleDate(copraSaleDTO.getSaleDate());
        copraSale.setCustomer(customerMapper.customerDtoToCustomer(copraSaleDTO.getCustomer()));
        copraSale.setShippingPlan(shippingPlanMapper.shippingPlanDtoToShippingPlan(copraSaleDTO.getShippingPlan()));
        copraSale.setPaymentDetails(paymentDetailsMapper.paymentDetailsDtoToPaymentDetails(copraSaleDTO.getPaymentDetails()));

        return saveAndReturnDTO(copraSale);
    }

    @Override
    public CopraSaleDTO patch(UUID id, CopraSaleDTO copraSaleDTO) {
        return copraSaleRepository.findById(id).map(copraSale -> {
            if(copraSaleDTO.getSaleQuantity() != null){
                copraSale.setSaleQuantity(copraSaleDTO.getSaleQuantity());
            }
            if(copraSaleDTO.getPricePerQuantity() != null){
                copraSale.setPricePerQuantity(copraSaleDTO.getPricePerQuantity());
            }
            if(copraSaleDTO.getTotalSaleAmount() != null){
                copraSale.setTotalSaleAmount(copraSaleDTO.getTotalSaleAmount());
            }
            if(copraSaleDTO.getSaleDate() != null){
                copraSale.setSaleDate(copraSaleDTO.getSaleDate());
            }
            if(copraSaleDTO.getCustomer() != null){
                copraSale.setCustomer(customerMapper.customerDtoToCustomer(copraSaleDTO.getCustomer()));
            }
            if(copraSaleDTO.getShippingPlan() != null){
                copraSale.setShippingPlan(shippingPlanMapper.shippingPlanDtoToShippingPlan(copraSaleDTO.getShippingPlan()));
            }
            if(copraSaleDTO.getPaymentDetails() != null){
                copraSale.setPaymentDetails(paymentDetailsMapper.paymentDetailsDtoToPaymentDetails(copraSaleDTO.getPaymentDetails()));
            }

            return saveAndReturnDTO(copraSale);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found copra sale with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        copraSaleRepository.deleteById(uuid);
    }

    private CopraSaleDTO saveAndReturnDTO(CopraSale copraSale){
        CopraSale returnCopraSale = copraSaleRepository.save(copraSale);
        return copraSaleMapper.copraSaleToCopraSaleDTO(returnCopraSale);
    }
}
