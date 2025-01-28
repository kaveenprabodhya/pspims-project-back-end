package com.al.exports.pspims.shared.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class BeverageProdOrderDTO extends BaseItem {

    private ProdOrderDetailsDTO prodOrderDetails;
    private BeverageTypeDTO beverageType;
}
