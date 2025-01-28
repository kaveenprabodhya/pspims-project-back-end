package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.Inventory;
import com.al.exports.pspims.shared.model.InventoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    InventoryDTO inventoryToInventoryDTO(Inventory inventory);

    Inventory inventoryDtoTOInventory(InventoryDTO inventoryDTO);
}
