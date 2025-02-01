package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.InventoryItemTypeEnum;
import com.al.exports.pspims.shared.enums.InventoryQuantityTypeEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class InventoryDTO extends BaseItem {

    @NotNull
    private InventoryItemTypeEnum inventoryItemType;
    @PositiveOrZero
    private Integer inventoryQuantity;
    private InventoryQuantityTypeEnum inventoryQuantityType;
    @PositiveOrZero
    private Integer minimumStockLevel;
    @Positive
    private Integer maximumStockLevel;
    private Set<CoconutPurchaseDTO> coconutPurchase;
}
