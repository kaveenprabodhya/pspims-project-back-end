package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

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
