package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.IngredientMeasureEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BeverageIngredientsDTO extends BaseItem {

    @NotBlank(message = "Ingredient name cannot be blank.")
    private String ingredientName;
    @Positive(message = "Measure amount must be a positive number.")
    private Float measureAmount;
    @NotNull(message = "Ingredient measure cannot be null.")
    private IngredientMeasureEnum ingredientMeasure;
    private BeverageTypeDTO beverageType;
}
