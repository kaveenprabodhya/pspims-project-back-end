package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.IngredientMeasureEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class BeverageIngredients extends BaseEntity {

    @Builder
    public BeverageIngredients(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String ingredientName, Float measureAmount, IngredientMeasureEnum ingredientMeasure, BeverageType beverageType) {
        super(id, version, createdDate, lastModifiedDate);
        this.ingredientName = ingredientName;
        this.measureAmount = measureAmount;
        this.ingredientMeasure = ingredientMeasure;
        this.beverageType = beverageType;
    }

    private String ingredientName;
    private Float measureAmount;
    @Enumerated(EnumType.STRING)
    private IngredientMeasureEnum ingredientMeasure;
    @ManyToOne
    private BeverageType beverageType;
}
