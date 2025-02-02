package com.al.exports.pspims.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor

@Entity
public class BeverageProdOrder extends BaseEntity {

    @Builder
    public BeverageProdOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                             ProdOrderDetails prodOrderDetails, BeverageType beverageType) {
        super(id, version, createdDate, lastModifiedDate);
        this.prodOrderDetails = prodOrderDetails;
        this.beverageType = beverageType;
    }

    // one bPO hv one pOD
    @OneToOne
    private ProdOrderDetails prodOrderDetails;
    // one bevType hv many bevPO
    @ManyToOne
    private BeverageType beverageType;
}
