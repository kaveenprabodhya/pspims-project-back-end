package com.al.exports.pspims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CoconutWaterProdOrder extends BaseEntity {

    // one cWPO hv one pOD
    @OneToOne
    private ProdOrderDetails prodOrderDetails;
}
