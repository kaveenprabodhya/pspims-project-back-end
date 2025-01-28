package com.al.exports.pspims.shared.mapper;

import com.al.exports.pspims.domain.BeverageType;
import com.al.exports.pspims.shared.model.BeverageTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BeverageTypeMapper {
    BeverageTypeMapper INSTANCE = Mappers.getMapper(BeverageTypeMapper.class);

    BeverageTypeDTO BeverageTypeToBeverageTypeDTO(BeverageType beverageType);

    BeverageType BeverageTypeDtotoBeverageType(BeverageTypeDTO beverageTypeDTO);
}
