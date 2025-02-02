package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.FermentationTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class VinegarProdOrderDTO extends BaseItem {

    @NotNull(message = "Production order details cannot be null.")
    private ProdOrderDetailsDTO prodOrderDetails;
    @NotNull(message = "Fermentation type cannot be null.")
    private FermentationTypeEnum fermentationType;
}
