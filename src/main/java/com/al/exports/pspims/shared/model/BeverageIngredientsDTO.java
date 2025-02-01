package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.IngredientMeasureEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class BeverageIngredientsDTO extends BaseItem {

    @NotBlank
    private String ingredientName;
    @Positive
    private Float measureAmount;
    @NotNull
    private IngredientMeasureEnum ingredientMeasure;
}
