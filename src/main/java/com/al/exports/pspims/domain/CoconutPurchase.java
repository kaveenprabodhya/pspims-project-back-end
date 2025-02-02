package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.CoconutQualityGradeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CoconutPurchase extends BaseEntity {

    @Builder
    public CoconutPurchase(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                           Integer purchaseQuantity, Float pricePerUnit, Float totalPurchaseCost,
                           Date purchaseDate, CoconutQualityGradeEnum coconutQualityGrade,
                           Inventory inventory, Supplier supplier) {
        super(id, version, createdDate, lastModifiedDate);
        this.purchaseQuantity = purchaseQuantity;
        this.pricePerUnit = pricePerUnit;
        this.totalPurchaseCost = totalPurchaseCost;
        this.purchaseDate = purchaseDate;
        this.coconutQualityGrade = coconutQualityGrade;
        this.inventory = inventory;
        this.supplier = supplier;
    }

    private Integer purchaseQuantity;
    private Float pricePerUnit;
    private Float totalPurchaseCost;
    private Date purchaseDate;
    @Enumerated(EnumType.STRING)
    private CoconutQualityGradeEnum coconutQualityGrade;
    // one inventory to many
    @ManyToOne
    private Inventory inventory;
    //one sup to many
    @ManyToOne
    private Supplier supplier;

    @PrePersist
    @PreUpdate
    private void calculateTotalPurchaseCost() {
        if (purchaseQuantity != null && pricePerUnit != null) {
            this.totalPurchaseCost = purchaseQuantity * pricePerUnit;
        }
    }
}
