package com.al.exports.pspims.shared.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class BeverageTypeDTO extends BaseItem {

    @NotBlank(message = "Beverage name cannot be blank.")
    private String beverageName;
    @NotBlank(message = "Beverage description cannot be blank.")
    private String beverageDescription;
    @NotNull(message = "Beverage status (active/inactive) is required.")
    private Boolean isActive;
    @NotBlank(message = "Nutrition information cannot be blank.")
    private String nutritionInfo;
}
