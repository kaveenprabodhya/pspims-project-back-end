package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.FermentationTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VinegarProdOrder extends BaseEntity {

    @Builder
    public VinegarProdOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                            ProdOrderDetails prodOrderDetails, FermentationTypeEnum fermentationType) {
        super(id, version, createdDate, lastModifiedDate);
        this.prodOrderDetails = prodOrderDetails;
        this.fermentationType = fermentationType;
    }

    // one vPO hv one pOD
    @OneToOne
    private ProdOrderDetails prodOrderDetails;
    @Enumerated(EnumType.STRING)
    private FermentationTypeEnum fermentationType;
}
