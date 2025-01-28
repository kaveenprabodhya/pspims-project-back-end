package com.al.exports.pspims.shared.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class BeverageTypeDTO extends BaseItem {

    private String beverageName;
    private String beverageDescription;
    private boolean isActive;
    private String nutritionInfo;
    private BeverageIngredientsDTO beverageIngredients;
    private Set<BeverageProdOrderDTO> beverageProdOrder;
}
