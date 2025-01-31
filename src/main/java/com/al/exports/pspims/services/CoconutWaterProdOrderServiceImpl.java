package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.CoconutWaterProdOrder;
import com.al.exports.pspims.repository.CoconutWaterProdOrderRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.CoconutWaterProdOrderMapper;
import com.al.exports.pspims.shared.mapper.ProdOrderDetailsMapper;
import com.al.exports.pspims.shared.model.CoconutWaterProdOrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoconutWaterProdOrderServiceImpl implements CoconutWaterProdOrderService {

    private final CoconutWaterProdOrderRepository coconutWaterProdOrderRepository;
    private final CoconutWaterProdOrderMapper coconutWaterProdOrderMapper;
    private final ProdOrderDetailsMapper prodOrderDetailsMapper;

    @Override
    public Page<CoconutWaterProdOrderDTO> findAll(Pageable pageable) {
        Page<CoconutWaterProdOrder> coconutWaterProdOrders = coconutWaterProdOrderRepository.findAll(pageable);
        return coconutWaterProdOrders.map(coconutWaterProdOrderMapper::coconutWaterProdOrderToCoconutWaterProdOrderDTO);
    }

    @Override
    public CoconutWaterProdOrderDTO findById(UUID uuid) {
        return coconutWaterProdOrderRepository
                .findById(uuid)
                .map(coconutWaterProdOrderMapper::coconutWaterProdOrderToCoconutWaterProdOrderDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found coconut water production order with id: " + uuid));
    }

    @Override
    public CoconutWaterProdOrderDTO create(CoconutWaterProdOrderDTO coconutWaterProdOrderDTO) {
        return saveAndReturnDTO(coconutWaterProdOrderMapper.CoconutWaterProdOrderDtoToCoconutWaterProdOrder(coconutWaterProdOrderDTO));
    }

    @Override
    public CoconutWaterProdOrderDTO update(UUID id, CoconutWaterProdOrderDTO coconutWaterProdOrderDTO) {
        CoconutWaterProdOrder coconutWaterProdOrder = coconutWaterProdOrderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found coconut water production order with id: " + id));
        coconutWaterProdOrder
                .setProdOrderDetails(prodOrderDetailsMapper
                        .prodOrderDetailsDtoToProdOrderDetails(coconutWaterProdOrderDTO.getProdOrderDetails())
                );
        return saveAndReturnDTO(coconutWaterProdOrder);
    }

    @Override
    public CoconutWaterProdOrderDTO patch(UUID id, CoconutWaterProdOrderDTO coconutWaterProdOrderDTO) {
        return coconutWaterProdOrderRepository.findById(id).map(coconutWaterProdOrder -> {
            if(coconutWaterProdOrderDTO.getProdOrderDetails() != null){
                coconutWaterProdOrder
                        .setProdOrderDetails(
                                prodOrderDetailsMapper
                                        .prodOrderDetailsDtoToProdOrderDetails(
                                                coconutWaterProdOrderDTO.getProdOrderDetails()
                                        )
                        );
            }
            return saveAndReturnDTO(coconutWaterProdOrder);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found coconut water production order with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        coconutWaterProdOrderRepository.deleteById(uuid);
    }

    private CoconutWaterProdOrderDTO saveAndReturnDTO(CoconutWaterProdOrder coconutWaterProdOrder){
        CoconutWaterProdOrder returnCoconutWaterProdOrder = coconutWaterProdOrderRepository.save(coconutWaterProdOrder);
        return coconutWaterProdOrderMapper.coconutWaterProdOrderToCoconutWaterProdOrderDTO(returnCoconutWaterProdOrder);
    }
}
