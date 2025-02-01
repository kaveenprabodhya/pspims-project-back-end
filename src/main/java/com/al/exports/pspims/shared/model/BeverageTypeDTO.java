package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class BeverageTypeDTO extends BaseItem {

    @NotBlank
    private String beverageName;
    @NotBlank
    private String beverageDescription;
    @NotNull
    private Boolean isActive;
    @NotBlank
    private String nutritionInfo;
    private BeverageIngredientsDTO beverageIngredients;
    private Set<BeverageProdOrderDTO> beverageProdOrder;
}
