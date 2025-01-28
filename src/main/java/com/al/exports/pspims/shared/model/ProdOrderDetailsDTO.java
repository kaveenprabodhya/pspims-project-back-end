package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.ProdStatusEnum;
import com.al.exports.pspims.shared.enums.ProductionQuantityMeasureEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ProdOrderDetailsDTO extends BaseItem {

    private Date prodDate;
    private Float prodQuantity;
    private ProductionQuantityMeasureEnum productionQuantityMeasure;
    private ProdStatusEnum prodStatus;
    private UUID batchNumber;
}
