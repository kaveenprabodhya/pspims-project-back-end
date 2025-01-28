package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.IngredientMeasureEnum;
import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BeverageIngredients extends BaseEntity {

    private String ingredientName;
    private float measureAmount;
    private IngredientMeasureEnum ingredientMeasure;
}
