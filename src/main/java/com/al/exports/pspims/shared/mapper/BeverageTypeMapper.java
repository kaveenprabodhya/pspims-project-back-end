package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.BeverageType;
import com.al.exports.pspims.shared.model.BeverageTypeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BeverageTypeMapper {
    BeverageTypeMapper INSTANCE = Mappers.getMapper(BeverageTypeMapper.class);

    @InheritInverseConfiguration
    BeverageTypeDTO BeverageTypeToBeverageTypeDTO(BeverageType beverageType);

    @Mapping(target = "beverageIngredients", ignore = true)
    @Mapping(target = "beverageProdOrder", ignore = true)
    BeverageType BeverageTypeDtotoBeverageType(BeverageTypeDTO beverageTypeDTO);
}
