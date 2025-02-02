package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class CoconutWaterProdOrder extends BaseEntity {

    @Builder
    public CoconutWaterProdOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                                 ProdOrderDetails prodOrderDetails) {
        super(id, version, createdDate, lastModifiedDate);
        this.prodOrderDetails = prodOrderDetails;
    }

    // one cWPO hv one pOD
    @OneToOne
    private ProdOrderDetails prodOrderDetails;
}
