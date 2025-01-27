package com.al.exports.pspims.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Inventory extends BaseEntity {

    private InventoryItemTypeEnum inventoryItemType;
    private Float inventoryQuantity;
    private Float minimumStockLevel;
    private Float maximumStockLevel;

    // one inventory many coco purchase
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Set<CoconutPurchase> coconutPurchase;
}
