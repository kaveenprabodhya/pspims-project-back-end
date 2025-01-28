package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.InventoryItemTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class InventoryDTO extends BaseItem {

    private InventoryItemTypeEnum inventoryItemType;
    private Float inventoryQuantity;
    private Float minimumStockLevel;
    private Float maximumStockLevel;
    private Set<CoconutPurchaseDTO> coconutPurchase;
}
