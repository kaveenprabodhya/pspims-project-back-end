package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.CoconutQualityGradeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CoconutPurchase extends BaseEntity {

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
