package com.al.exports.pspims.shared.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class BeverageProdOrderDTO extends BaseItem {

    @NotNull(message = "Production order details cannot be null.")
    private ProdOrderDetailsDTO prodOrderDetails;
    @NotNull(message = "Beverage type cannot be null.")
    private BeverageTypeDTO beverageType;
}
