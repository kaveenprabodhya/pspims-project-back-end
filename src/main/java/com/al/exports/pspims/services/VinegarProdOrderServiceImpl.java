package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.VinegarProdOrder;
import com.al.exports.pspims.repository.VinegarProdOrderRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.ProdOrderDetailsMapper;
import com.al.exports.pspims.shared.mapper.VinegarProdOrderMapper;
import com.al.exports.pspims.shared.model.VinegarProdOrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class VinegarProdOrderServiceImpl implements VinegarProdOrderService {

    private final VinegarProdOrderRepository vinegarProdOrderRepository;
    private final VinegarProdOrderMapper vinegarProdOrderMapper;
    private final ProdOrderDetailsMapper prodOrderDetailsMapper;

    @Override
    public Page<VinegarProdOrderDTO> findAll(Pageable pageable) {
        Page<VinegarProdOrder> vinegarProdOrders = vinegarProdOrderRepository.findAll(pageable);
        return vinegarProdOrders.map(vinegarProdOrderMapper::vinegarProdOrderToVinegarProdOrderDTO);
    }

    @Override
    public VinegarProdOrderDTO findById(UUID uuid) {
        return vinegarProdOrderRepository
                .findById(uuid)
                .map(vinegarProdOrderMapper::vinegarProdOrderToVinegarProdOrderDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found vinegar production order with id: " + uuid));
    }

    @Override
    public VinegarProdOrderDTO create(VinegarProdOrderDTO vinegarProdOrderDTO) {
        return saveAndReturnDTO(vinegarProdOrderMapper.vinegarProdOrderDtoToVinegarProdOrder(vinegarProdOrderDTO));
    }

    @Override
    public VinegarProdOrderDTO update(UUID id, VinegarProdOrderDTO vinegarProdOrderDTO) {
        VinegarProdOrder vinegarProdOrder = vinegarProdOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found vinegar production order with id: " + id));
        vinegarProdOrder.setProdOrderDetails(prodOrderDetailsMapper.prodOrderDetailsDtoToProdOrderDetails(vinegarProdOrderDTO.getProdOrderDetails()));
        vinegarProdOrder.setFermentationType(vinegarProdOrderDTO.getFermentationType());
        return saveAndReturnDTO(vinegarProdOrder);
    }

    @Override
    public VinegarProdOrderDTO patch(UUID id, VinegarProdOrderDTO vinegarProdOrderDTO) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {
        vinegarProdOrderRepository.deleteById(uuid);
    }

    private VinegarProdOrderDTO saveAndReturnDTO(VinegarProdOrder vinegarProdOrder){
        VinegarProdOrder returnVinegarProdOrder = vinegarProdOrderRepository.save(vinegarProdOrder);
        return vinegarProdOrderMapper.vinegarProdOrderToVinegarProdOrderDTO(returnVinegarProdOrder);
    }
}
