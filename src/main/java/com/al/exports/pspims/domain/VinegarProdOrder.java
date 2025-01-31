package com.al.exports.pspims.domain;

import com.al.exports.pspims.shared.enums.FermentationTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.*;

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
    @Enumerated(EnumType.STRING)
    private FermentationTypeEnum fermentationType;
}
