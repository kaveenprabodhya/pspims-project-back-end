package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.InventoryItemTypeEnum;
import com.al.exports.pspims.shared.enums.InventoryQuantityTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Inventory extends BaseEntity {

    @Builder
    public Inventory(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                     InventoryItemTypeEnum inventoryItemType, Integer inventoryQuantity,
                     InventoryQuantityTypeEnum inventoryQuantityType, Integer minimumStockLevel,
                     Integer maximumStockLevel, Set<CoconutPurchase> coconutPurchase) {
        super(id, version, createdDate, lastModifiedDate);
        this.inventoryItemType = inventoryItemType;
        this.inventoryQuantity = inventoryQuantity;
        this.inventoryQuantityType = inventoryQuantityType;
        this.minimumStockLevel = minimumStockLevel;
        this.maximumStockLevel = maximumStockLevel;
        this.coconutPurchase = coconutPurchase;
    }

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
