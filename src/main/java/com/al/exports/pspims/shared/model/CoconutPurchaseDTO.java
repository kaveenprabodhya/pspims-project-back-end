package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.CoconutQualityGradeEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CoconutPurchaseDTO extends BaseItem {

    @Positive
    private Integer purchaseQuantity;
    @Positive
    private Float pricePerUnit;
    @Positive
    private Float totalPurchaseCost;
    @PastOrPresent
    private Date purchaseDate;
    @NotNull
    private CoconutQualityGradeEnum coconutQualityGrade;
    private InventoryDTO inventory;
    private SupplierDTO supplier;
}
