package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.CoconutQualityGradeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CoconutPurchaseDTO extends BaseItem {

    private Integer purchaseQuantity;
    private float pricePerUnit;
    private float totalPurchaseCost;
    private Date purchaseDate;
    private CoconutQualityGradeEnum coconutQualityGrade;
    private InventoryDTO inventory;
    private SupplierDTO supplier;
}
