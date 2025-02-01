package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.ProdStatusEnum;
import com.al.exports.pspims.shared.enums.ProductionQuantityMeasureEnum;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ProdOrderDetailsDTO extends BaseItem {

    @FutureOrPresent
    private Date prodDate;
    @Positive
    private Float prodQuantity;
    @Positive
    private Float pricePerUnit;
    @Positive
    private Float totalAmount;
    @NotNull
    private ProductionQuantityMeasureEnum productionQuantityMeasure;
    @NotNull
    private ProdStatusEnum prodStatus;
    @NotNull
    private UUID batchNumber;
}
