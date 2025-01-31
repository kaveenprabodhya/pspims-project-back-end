package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.IngredientMeasureEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BeverageIngredients extends BaseEntity {

    private String ingredientName;
    private Float measureAmount;
    @Enumerated(EnumType.STRING)
    private IngredientMeasureEnum ingredientMeasure;
}
