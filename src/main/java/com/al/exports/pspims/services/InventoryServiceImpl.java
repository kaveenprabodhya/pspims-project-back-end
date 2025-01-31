package com.al.exports.pspims.services;


import com.al.exports.pspims.domain.Inventory;
import com.al.exports.pspims.repository.InventoryRepository;
import com.al.exports.pspims.shared.exceptions.ResourceNotFoundException;
import com.al.exports.pspims.shared.mapper.InventoryMapper;
import com.al.exports.pspims.shared.model.InventoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Override
    public Page<InventoryDTO> findAll(Pageable pageable) {
        Page<Inventory> inventories = inventoryRepository.findAll(pageable);
        return inventories.map(inventoryMapper::inventoryToInventoryDTO);
    }

    @Override
    public InventoryDTO findById(UUID uuid) {
        return inventoryRepository.
                findById(uuid)
                .map(inventoryMapper::inventoryToInventoryDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Not found inventory with id: " + uuid));
    }

    @Override
    public InventoryDTO create(InventoryDTO inventoryDTO) {
        return saveAndReturnDTO(inventoryMapper.inventoryDtoTOInventory(inventoryDTO));
    }

    @Override
    public InventoryDTO update(UUID id, InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found inventory with id: " + id));
        inventory.setInventoryItemType(inventoryDTO.getInventoryItemType());
        inventory.setInventoryQuantity(inventoryDTO.getInventoryQuantity());
        inventory.setMinimumStockLevel(inventoryDTO.getMinimumStockLevel());
        inventory.setMaximumStockLevel(inventoryDTO.getMaximumStockLevel());
        return saveAndReturnDTO(inventory);
    }

    @Override
    public InventoryDTO patch(UUID id, InventoryDTO inventoryDTO) {
        return inventoryRepository.findById(id).map(inventory -> {
            if(inventoryDTO.getInventoryItemType() != null){
                inventory.setInventoryItemType(inventoryDTO.getInventoryItemType());
            }
            if(inventoryDTO.getInventoryQuantity() != null){
                inventory.setInventoryQuantity(inventoryDTO.getInventoryQuantity());
            }
            if(inventoryDTO.getMaximumStockLevel() != null){
                inventory.setMaximumStockLevel(inventoryDTO.getMaximumStockLevel());
            }
            if(inventoryDTO.getMinimumStockLevel() != null){
                inventory.setMinimumStockLevel(inventoryDTO.getMinimumStockLevel());
            }
            return  saveAndReturnDTO(inventory);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found inventory with id: " + id));
    }

    @Override
    public void deleteById(UUID uuid) {
        inventoryRepository.deleteById(uuid);
    }

    private InventoryDTO saveAndReturnDTO(Inventory inventory){
        Inventory returnInventory = inventoryRepository.save(inventory);
        return inventoryMapper.inventoryToInventoryDTO(returnInventory);
    }
}
