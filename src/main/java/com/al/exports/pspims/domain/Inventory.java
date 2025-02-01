package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.InventoryItemTypeEnum;
import com.al.exports.pspims.shared.enums.InventoryQuantityTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Inventory extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private InventoryItemTypeEnum inventoryItemType;
    private Integer inventoryQuantity;
    @Enumerated(EnumType.STRING)
    private InventoryQuantityTypeEnum inventoryQuantityType;
    private Integer minimumStockLevel;
    private Integer maximumStockLevel;

    // one inventory many coco purchase
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Set<CoconutPurchase> coconutPurchase;
}
