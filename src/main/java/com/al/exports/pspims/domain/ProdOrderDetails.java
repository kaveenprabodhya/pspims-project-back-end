package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.ProdStatusEnum;
import com.al.exports.pspims.shared.enums.ProductionQuantityMeasureEnum;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private ProductionQuantityMeasureEnum productionQuantityMeasure;
    @Enumerated(EnumType.STRING)
    private ProdStatusEnum prodStatus;
    @Column(length = 36, unique = true, nullable = false)
    private UUID batchNumber;

    @PrePersist
    public void generateBatchNO() {
        if (this.batchNumber == null) {
            this.batchNumber = UUID.randomUUID(); // Generate only if not set
        }
    }
}
