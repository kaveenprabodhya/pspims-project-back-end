package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.ProdStatusEnum;
import com.al.exports.pspims.shared.enums.ProductionQuantityMeasureEnum;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProdOrderDetails extends BaseEntity {

    private Date prodDate;
    private Float prodQuantity;
    private ProductionQuantityMeasureEnum productionQuantityMeasure;
    private ProdStatusEnum prodStatus;
    private UUID batchNumber;
}
