package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.BeverageProdOrder;
import com.al.exports.pspims.repository.BeverageProdOrderRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.BeverageProdOrderMapper;
import com.al.exports.pspims.shared.mapper.BeverageTypeMapper;
import com.al.exports.pspims.shared.mapper.ProdOrderDetailsMapper;
import com.al.exports.pspims.shared.model.BeverageProdOrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeverageProdOrderServiceImpl implements BeverageProdOrderService {

    private final BeverageProdOrderRepository beverageProdOrderRepository;
    private final BeverageProdOrderMapper beverageProdOrderMapper;
    private final BeverageTypeMapper beverageTypeMapper;
    private final ProdOrderDetailsMapper prodOrderDetailsMapper;

    @Override
    public Page<BeverageProdOrderDTO> findAll(Pageable pageable) {
        Page<BeverageProdOrder> beverageProdOrders = beverageProdOrderRepository.findAll(pageable);
        return beverageProdOrders.
                map(beverageProdOrderMapper::beverageProdOrderToBeverageProdOrderDTO);
    }

    @Override
    public BeverageProdOrderDTO findById(UUID uuid) {
        return beverageProdOrderRepository
                .findById(uuid)
                .map(beverageProdOrderMapper::beverageProdOrderToBeverageProdOrderDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found beverage production order with id: " + uuid));
    }

    @Override
    public BeverageProdOrderDTO create(BeverageProdOrderDTO beverageProdOrderDTO) {
        return saveAndReturnDTO(beverageProdOrderMapper.beverageProdOrderDtoToBeverageProdOrder(beverageProdOrderDTO));
    }

    @Override
    public BeverageProdOrderDTO update(UUID id, BeverageProdOrderDTO beverageProdOrderDTO) {
        BeverageProdOrder beverageProdOrder = beverageProdOrderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found beverage production order with id: " + id));
        beverageProdOrder.setBeverageType(beverageTypeMapper.BeverageTypeDtotoBeverageType(beverageProdOrderDTO.getBeverageType()));
        beverageProdOrder.setProdOrderDetails(prodOrderDetailsMapper.prodOrderDetailsDtoToProdOrderDetails(beverageProdOrderDTO.getProdOrderDetails()));
        return saveAndReturnDTO(beverageProdOrder);
    }

    @Override
    public BeverageProdOrderDTO patch(UUID id, BeverageProdOrderDTO beverageProdOrderDTO) {
        return beverageProdOrderRepository.findById(id).map(beverageProdOrder -> {
            if(beverageProdOrderDTO.getProdOrderDetails() != null){
                beverageProdOrder.setProdOrderDetails(prodOrderDetailsMapper.prodOrderDetailsDtoToProdOrderDetails(beverageProdOrderDTO.getProdOrderDetails()));
            }
            if(beverageProdOrderDTO.getBeverageType() != null){
                beverageProdOrder.setBeverageType(beverageTypeMapper.BeverageTypeDtotoBeverageType(beverageProdOrderDTO.getBeverageType()));
            }
            return saveAndReturnDTO(beverageProdOrder);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found beverage production order with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        beverageProdOrderRepository.deleteById(uuid);
    }

    private BeverageProdOrderDTO saveAndReturnDTO(BeverageProdOrder beverageProdOrder){
        BeverageProdOrder returnBeverageProdOrder = beverageProdOrderRepository.save(beverageProdOrder);
        return beverageProdOrderMapper.beverageProdOrderToBeverageProdOrderDTO(returnBeverageProdOrder);
    }
}
