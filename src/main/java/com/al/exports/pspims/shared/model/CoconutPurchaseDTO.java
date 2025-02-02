package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.CoconutQualityGradeEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CoconutPurchaseDTO extends BaseItem {

    @Positive(message = "Purchase quantity must be a positive number.")
    private Integer purchaseQuantity;
    @Positive(message = "Price per unit must be a positive number.")
    private Float pricePerUnit;
    @Setter(AccessLevel.NONE)
    private Float totalPurchaseCost;
    @PastOrPresent(message = "Purchase date cannot be in the future.")
    private Date purchaseDate;
    @NotNull(message = "Coconut quality grade is required.")
    private CoconutQualityGradeEnum coconutQualityGrade;
    private InventoryDTO inventory;
    private SupplierDTO supplier;
}
