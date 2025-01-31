package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.InventoryItemTypeEnum;
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
    private Float inventoryQuantity;
    private Float minimumStockLevel;
    private Float maximumStockLevel;

    // one inventory many coco purchase
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Set<CoconutPurchase> coconutPurchase;
}
