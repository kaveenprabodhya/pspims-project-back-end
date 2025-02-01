package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CoconutWaterProdOrderDTO extends BaseItem {

    @NotNull
    private ProdOrderDetailsDTO prodOrderDetails;
}
