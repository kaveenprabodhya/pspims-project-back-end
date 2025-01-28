package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.BeverageIngredients;
import com.al.exports.pspims.shared.model.BeverageIngredientsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BeverageIngredientsMapper {
    BeverageIngredientsMapper INSTANCE = Mappers.getMapper(BeverageIngredientsMapper.class);

    BeverageIngredientsDTO beverageIngredientsToBeverageIngredientsDTO(BeverageIngredients beverageIngredients);

    BeverageIngredients beverageIngredientsDtoToBeverageIngredients(BeverageIngredientsDTO beverageIngredientsDTO);
}
