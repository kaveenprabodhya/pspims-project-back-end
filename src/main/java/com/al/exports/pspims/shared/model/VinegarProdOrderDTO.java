package com.al.exports.pspims.shared.model;

import com.al.exports.pspims.shared.enums.FermentationTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class VinegarProdOrderDTO extends BaseItem {

    private ProdOrderDetailsDTO prodOrderDetails;
    private FermentationTypeEnum fermentationType;
}
