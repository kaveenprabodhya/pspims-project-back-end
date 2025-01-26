package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Inventory extends BaseEntity {

    @Builder
    public Inventory(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, Float minimumStockLevel,
                     Float maximumStockLevel, Float inventoryQuantity) {
        super(id, version, createdDate, lastModifiedDate);
        this.minimumStockLevel = minimumStockLevel;
        this.maximumStockLevel = maximumStockLevel;
        this.inventoryQuantity = inventoryQuantity;
    }

    private Float inventoryQuantity;
    private Float minimumStockLevel;
    private Float maximumStockLevel;
}
