package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.InventoryItemTypeEnum;
import com.al.exports.pspims.shared.enums.InventoryQuantityTypeEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class InventoryDTO extends BaseItem {

    @NotNull(message = "Inventory item type cannot be null.")
    private InventoryItemTypeEnum inventoryItemType;
    @PositiveOrZero(message = "Inventory quantity must be zero or a positive number.")
    private Integer inventoryQuantity;
    @NotNull(message = "Inventory quantity type cannot be null.")
    private InventoryQuantityTypeEnum inventoryQuantityType;
    @PositiveOrZero(message = "Minimum stock level must be zero or a positive number.")
    private Integer minimumStockLevel;
    @Positive(message = "Maximum stock level must be a positive number.")
    private Integer maximumStockLevel;
}
