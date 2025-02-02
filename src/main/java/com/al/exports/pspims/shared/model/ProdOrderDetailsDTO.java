package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.ProdStatusEnum;
import com.al.exports.pspims.shared.enums.ProductionQuantityMeasureEnum;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ProdOrderDetailsDTO extends BaseItem {

    @NotNull(message = "Production date is required.")
    @FutureOrPresent(message = "Production date cannot be in the past.")
    private Date prodDate;
    @Positive(message = "Production quantity must be a positive number.")
    private Float prodQuantity;
    @Positive(message = "Price per unit must be a positive number.")
    private Float pricePerUnit;
    @Setter(AccessLevel.NONE)
    private Float totalAmount;
    @NotNull(message = "Production quantity measure is required.")
    private ProductionQuantityMeasureEnum productionQuantityMeasure;
    @NotNull(message = "Production status is required.")
    private ProdStatusEnum prodStatus;
    @Setter(AccessLevel.NONE)
    private UUID batchNumber;
}
