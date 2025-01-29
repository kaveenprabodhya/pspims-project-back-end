package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.IngredientMeasureEnum;
import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class BeverageIngredientsDTO extends BaseItem {

    private String ingredientName;
    private Float measureAmount;
    private IngredientMeasureEnum ingredientMeasure;
}
