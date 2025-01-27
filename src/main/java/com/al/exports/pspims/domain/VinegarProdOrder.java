package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class VinegarProdOrder extends BaseEntity {

    // one vPO hv one pOD
    @OneToOne
    private ProdOrderDetails prodOrderDetails;

    private FermentationTypeEnum fermentationType;
}
