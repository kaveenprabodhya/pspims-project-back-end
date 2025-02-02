package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CoconutWaterProdOrderDTO extends BaseItem {

    @NotNull(message = "Production order details cannot be null.")
    private ProdOrderDetailsDTO prodOrderDetails;
}
