package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.FermentationTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class VinegarProdOrderDTO extends BaseItem {

    @NotNull
    private ProdOrderDetailsDTO prodOrderDetails;
    @NotNull
    private FermentationTypeEnum fermentationType;
}
