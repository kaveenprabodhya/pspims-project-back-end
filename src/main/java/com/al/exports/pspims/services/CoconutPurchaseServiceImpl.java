package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.CoconutPurchase;
import com.al.exports.pspims.repository.CoconutPurchaseRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.CoconutPurchaseMapper;
import com.al.exports.pspims.shared.mapper.InventoryMapper;
import com.al.exports.pspims.shared.mapper.SupplierMapper;
import com.al.exports.pspims.shared.model.CoconutPurchaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoconutPurchaseServiceImpl implements CoconutPurchaseService {

    private final CoconutPurchaseRepository coconutPurchaseRepository;
    private final CoconutPurchaseMapper coconutPurchaseMapper;
    private final SupplierMapper supplierMapper;
    private final InventoryMapper inventoryMapper;

    @Override
    public Page<CoconutPurchaseDTO> findAll(Pageable pageable) {
        Page<CoconutPurchase> coconutPurchases = coconutPurchaseRepository.findAll(pageable);
        return coconutPurchases.map(coconutPurchaseMapper::coconutPurchaseToCoconutPurchaseDTO);
    }

    @Override
    public CoconutPurchaseDTO findById(UUID uuid) {
        return coconutPurchaseRepository.
                findById(uuid)
                .map(coconutPurchaseMapper::coconutPurchaseToCoconutPurchaseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found coconut purchase with id: " + uuid));
    }

    @Override
    public CoconutPurchaseDTO create(CoconutPurchaseDTO coconutPurchaseDTO) {
        return saveAndReturnDTO(coconutPurchaseMapper.CoconutPurchaseDtoToCoconutPurchase(coconutPurchaseDTO));
    }

    @Override
    public CoconutPurchaseDTO update(UUID id, CoconutPurchaseDTO coconutPurchaseDTO) {
        CoconutPurchase coconutPurchase = coconutPurchaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found coconut purchase with id: " + id));
        coconutPurchase.setPurchaseQuantity(coconutPurchaseDTO.getPurchaseQuantity());
        coconutPurchase.setPricePerUnit(coconutPurchaseDTO.getPricePerUnit());
        coconutPurchase.setTotalPurchaseCost(coconutPurchaseDTO.getTotalPurchaseCost());
        coconutPurchase.setPurchaseDate(coconutPurchaseDTO.getPurchaseDate());
        coconutPurchase.setCoconutQualityGrade(coconutPurchaseDTO.getCoconutQualityGrade());
        coconutPurchase.setInventory(inventoryMapper.inventoryDtoTOInventory(coconutPurchaseDTO.getInventory()));
        coconutPurchase.setSupplier(supplierMapper.supplierDtoToSupplier(coconutPurchaseDTO.getSupplier()));
        return saveAndReturnDTO(coconutPurchase);
    }

    @Override
    public CoconutPurchaseDTO patch(UUID id, CoconutPurchaseDTO coconutPurchaseDTO) {
        return coconutPurchaseRepository.findById(id).map(coconutPurchase -> {
            if(coconutPurchaseDTO.getPurchaseQuantity() != null){
                coconutPurchase.setPurchaseQuantity(coconutPurchaseDTO.getPurchaseQuantity());
            }if(coconutPurchaseDTO.getPricePerUnit() != null){
                coconutPurchase.setPricePerUnit(coconutPurchaseDTO.getPricePerUnit());
            }if(coconutPurchaseDTO.getTotalPurchaseCost() != null){
                coconutPurchase.setTotalPurchaseCost(coconutPurchaseDTO.getTotalPurchaseCost());
            }if(coconutPurchaseDTO.getPurchaseDate() != null){
                coconutPurchase.setPurchaseDate(coconutPurchaseDTO.getPurchaseDate());
            }if(coconutPurchaseDTO.getCoconutQualityGrade() != null){
                coconutPurchase.setCoconutQualityGrade(coconutPurchaseDTO.getCoconutQualityGrade());
            }if(coconutPurchaseDTO.getInventory() != null){
                coconutPurchase.setInventory(inventoryMapper.inventoryDtoTOInventory(coconutPurchaseDTO.getInventory()));
            }if(coconutPurchaseDTO.getSupplier() != null){
                coconutPurchase.setSupplier(supplierMapper.supplierDtoToSupplier(coconutPurchaseDTO.getSupplier()));
            }
            return saveAndReturnDTO(coconutPurchase);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found coconut purchase with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        coconutPurchaseRepository.deleteById(uuid);
    }

    private CoconutPurchaseDTO saveAndReturnDTO(CoconutPurchase coconutPurchase){
        CoconutPurchase returnCoconutPurchase = coconutPurchaseRepository.save(coconutPurchase);
        return coconutPurchaseMapper.coconutPurchaseToCoconutPurchaseDTO(returnCoconutPurchase);
    }
}
