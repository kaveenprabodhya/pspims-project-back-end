package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.ProdStatusEnum;
import com.al.exports.pspims.shared.enums.ProductionQuantityMeasureEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ProdOrderDetails extends BaseEntity {

    @Builder
    public ProdOrderDetails(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                            Date prodDate, Float prodQuantity, Float pricePerUnit, Float totalAmount,
                            ProductionQuantityMeasureEnum productionQuantityMeasure, ProdStatusEnum prodStatus,
                            UUID batchNumber) {
        super(id, version, createdDate, lastModifiedDate);
        this.prodDate = prodDate;
        this.prodQuantity = prodQuantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
        this.productionQuantityMeasure = productionQuantityMeasure;
        this.prodStatus = prodStatus;
        this.batchNumber = batchNumber;
    }

    private Date prodDate;
    private Float prodQuantity;
    private Float pricePerUnit;
    private Float totalAmount;
    @Enumerated(EnumType.STRING)
    private ProductionQuantityMeasureEnum productionQuantityMeasure;
    @Enumerated(EnumType.STRING)
    private ProdStatusEnum prodStatus;
    @Column(length = 36, unique = true, nullable = false)
    private UUID batchNumber;

    @PrePersist
    @PreUpdate
    public void generateBatchNO() {
        if (this.batchNumber == null) {
            this.batchNumber = UUID.randomUUID(); // Generate only if not set
        }

        if (prodQuantity != null && pricePerUnit != null) {
            this.totalAmount = prodQuantity * pricePerUnit;
        }
    }
}
