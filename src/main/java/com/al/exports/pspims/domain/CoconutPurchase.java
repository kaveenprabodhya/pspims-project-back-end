package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
    private float pricePerUnit;
    private float totalPurchaseCost;
    private Date purchaseDate;
    private CoconutQualityGradeEnum coconutQualityGrade;
    // one inventory to many
    @ManyToOne
    private Inventory inventory;
    //one sup to many
    @ManyToOne
    private Supplier supplier;
}
